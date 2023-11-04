package edu.pe.cibertec.Fastrack_DSW1_Grupo7.Service;

import edu.pe.cibertec.Fastrack_DSW1_Grupo7.Model.Empleado;
import edu.pe.cibertec.Fastrack_DSW1_Grupo7.Model.Locales;
import edu.pe.cibertec.Fastrack_DSW1_Grupo7.Repository.LocalesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocalesService {

    private final LocalesRepository localesRepository;

    public List<Locales> listaLocales() {
        return localesRepository.findAll();
    }

    public Locales registrarLocal(Locales local) {
        return localesRepository.save(local);
    }

    public Optional<Locales> obtenerLocalPorId(Integer id) {
        return localesRepository.findById(id);
    }

    public void eliminarLocal(Integer id) {
        localesRepository.deleteById(id);
    }

    public List<Locales> buscarLocalesPorNombreLocal(String nombrelocal) {
        return localesRepository.findByNombrelocalContaining(nombrelocal);
    }
}