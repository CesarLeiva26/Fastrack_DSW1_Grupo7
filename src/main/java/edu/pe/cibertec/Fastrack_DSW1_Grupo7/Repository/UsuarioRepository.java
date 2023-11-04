package edu.pe.cibertec.Fastrack_DSW1_Grupo7.Repository;

import edu.pe.cibertec.Fastrack_DSW1_Grupo7.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends
        JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);
    Usuario findByNomusuario(String nomusuario);
}
