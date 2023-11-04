package edu.pe.cibertec.Fastrack_DSW1_Grupo7.Repository;

import edu.pe.cibertec.Fastrack_DSW1_Grupo7.Model.Locales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LocalesRepository extends JpaRepository<Locales,Integer>{
    List<Locales> findByNombrelocalContaining(String nombrelocal);

}

