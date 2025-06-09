package georesgate.service;

import georesgate.model.Usuario;
import georesgate.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.listAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Transactional
    public void salvar(Usuario usuario) {
        usuarioRepository.persist(usuario);
    }

    @Transactional
    public boolean atualizar(Long id, Usuario novoUsuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente == null) return false;

        usuarioExistente.setNome(novoUsuario.getNome());
        usuarioExistente.setCpf(novoUsuario.getCpf());
        usuarioExistente.setTelefone(novoUsuario.getTelefone());
        usuarioExistente.setMembrosFamilia(novoUsuario.getMembrosFamilia());

        // Se quiser atualizar a residência, você deve acessar via:
        // usuarioExistente.getResidencia().setTipoResidencia(...); etc.

        return true;
    }

    @Transactional
    public boolean deletar(Long id) {
        return usuarioRepository.deleteById(id);
    }
}