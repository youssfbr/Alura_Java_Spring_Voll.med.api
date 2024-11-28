package com.github.youssfbr.voll.med.api.domains.usuarios;

import com.github.youssfbr.voll.med.api.domains.roles.IRoleRepository;
import com.github.youssfbr.voll.med.api.domains.roles.Role;
import com.github.youssfbr.voll.med.api.domains.roles.RoleDTO;
import com.github.youssfbr.voll.med.api.domains.usuarios.dtos.DadosAtualizacaoUsuarioDTO;
import com.github.youssfbr.voll.med.api.domains.usuarios.dtos.DadosCadastroUsuarioDTO;
import com.github.youssfbr.voll.med.api.domains.usuarios.dtos.DadosDetalhamentoUsuarioDTO;
import com.github.youssfbr.voll.med.api.domains.usuarios.dtos.DadosListagemUsuarioDTO;
import com.github.youssfbr.voll.med.api.infra.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    private final IUsuarioRepository usuarioRepository;
    private final IRoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(IUsuarioRepository usuarioRepository , IRoleRepository roleRepository , BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DadosListagemUsuarioDTO> paginar(Pageable paginacao) {
        return usuarioRepository.findAllPageByAtivoTrue(paginacao)
                .map(DadosListagemUsuarioDTO::new);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DadosListagemUsuarioDTO> listar() {
        return usuarioRepository.findAllByAtivoTrueOrderById().stream()
                .map(DadosListagemUsuarioDTO::new)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public DadosDetalhamentoUsuarioDTO listarPorId(Long id) {
        return new DadosDetalhamentoUsuarioDTO(getEntityNotFound(id));
    }

    @Override
    @Transactional
    public DadosDetalhamentoUsuarioDTO cadastrar(DadosCadastroUsuarioDTO dados) {

        Usuario usuarioASerCriado = new Usuario(dados);
        usuarioASerCriado.setSenha(passwordEncoder.encode(dados.senha()));

        usuarioASerCriado.getRoles().clear();

        dados.roles().forEach(roleDTO -> {
            Role role = roleRepository.getReferenceById(roleDTO.id());
            usuarioASerCriado.getRoles().add(role);
        });

        Usuario usuarioCriado = usuarioRepository.save(usuarioASerCriado);

        return new DadosDetalhamentoUsuarioDTO(usuarioCriado);
    }

    @Override
    @Transactional
    public DadosDetalhamentoUsuarioDTO atualizarInformacoes(DadosAtualizacaoUsuarioDTO dados) {

        Usuario usuarioASerAlterado  = getEntityNotFound(dados.id());

        usuarioASerAlterado.getRoles().clear();

        for (RoleDTO roleDTO : dados.roles()) {
            Role role = roleRepository.getReferenceById(roleDTO.id());
            usuarioASerAlterado.getRoles().add(role);
        }

        usuarioASerAlterado.atualizarInformacoes(dados);
        return new DadosDetalhamentoUsuarioDTO(usuarioASerAlterado);
    }

    @Override
    @Transactional
    public void remover(Long id) {
        getEntityNotFound(id).inativar();
    }

    private Usuario getEntityNotFound(Long id) {
        return usuarioRepository.getReferenceByIdAndAtivoTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
    }

}
