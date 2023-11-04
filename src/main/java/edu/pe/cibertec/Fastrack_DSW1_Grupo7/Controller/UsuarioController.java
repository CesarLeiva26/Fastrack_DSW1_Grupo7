package edu.pe.cibertec.Fastrack_DSW1_Grupo7.Controller;

import edu.pe.cibertec.Fastrack_DSW1_Grupo7.Exception.ResourceNotFoundException;
import edu.pe.cibertec.Fastrack_DSW1_Grupo7.Model.Usuario;
import edu.pe.cibertec.Fastrack_DSW1_Grupo7.Service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("")
    public ResponseEntity<List<Usuario>> listaUsuarios() {
        List<Usuario> usuariosList = usuarioService.listaUsuarios();
        if (usuariosList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(usuariosList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable("id") Integer id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El usuario con el ID " + id + " no existe"));
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.registrarUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable("id") Integer id, @RequestBody Usuario usuario) {
        Usuario oldUsuario = usuarioService.obtenerUsuarioPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El usuario con el ID " +
                        id + " no existe"));
        oldUsuario.setNombres(usuario.getNombres());
        oldUsuario.setApellidos(usuario.getApellidos());
        oldUsuario.setEmail(usuario.getEmail());
        oldUsuario.setNomusuario(usuario.getNomusuario());
        oldUsuario.setPassword(usuario.getPassword());
        oldUsuario.setActivo(usuario.getActivo());
        usuarioService.registrarUsuario(oldUsuario);
        return new ResponseEntity<>(oldUsuario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable("id") Integer id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El usuario con el ID " + id + " no existe"));
        usuarioService.eliminarUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
