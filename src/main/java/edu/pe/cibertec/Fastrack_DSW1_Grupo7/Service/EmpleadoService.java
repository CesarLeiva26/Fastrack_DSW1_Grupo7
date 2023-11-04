package edu.pe.cibertec.Fastrack_DSW1_Grupo7.Service;

import edu.pe.cibertec.Fastrack_DSW1_Grupo7.Model.Empleado;
import edu.pe.cibertec.Fastrack_DSW1_Grupo7.Repository.EmpleadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public List<Empleado> listaEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado registrarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Optional<Empleado> obtenerEmpleadoPorId(Integer id) {
        return empleadoRepository.findById(id);
    }

    public void eliminarEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
    }
    public List<Empleado> obtenerEmpleadosPorNombre(String nombre) {
        return empleadoRepository.findByNombreContaining(nombre);
    }
}
