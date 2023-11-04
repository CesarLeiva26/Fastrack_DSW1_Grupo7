package edu.pe.cibertec.Fastrack_DSW1_Grupo7.Service;

import edu.pe.cibertec.Fastrack_DSW1_Grupo7.Model.Usuario;
import edu.pe.cibertec.Fastrack_DSW1_Grupo7.Repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<Usuario> listaUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> obtenerUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

    // Puedes agregar más métodos personalizados según tus necesidades
}
