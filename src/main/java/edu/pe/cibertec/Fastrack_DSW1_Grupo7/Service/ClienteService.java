package edu.pe.cibertec.Fastrack_DSW1_Grupo7.Service;

import edu.pe.cibertec.Fastrack_DSW1_Grupo7.Model.Cliente;
import edu.pe.cibertec.Fastrack_DSW1_Grupo7.Repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> listaClientes() {
        return clienteRepository.findAll();
    }

    public Cliente registrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> obtenerClientePorId(Integer id) {
        return clienteRepository.findById(id);
    }

    public void eliminarCliente(Integer id) {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> obtenerEmpleadosPorNombre(String nombre){
        return clienteRepository.findByNombreContaining(nombre);
    }
}