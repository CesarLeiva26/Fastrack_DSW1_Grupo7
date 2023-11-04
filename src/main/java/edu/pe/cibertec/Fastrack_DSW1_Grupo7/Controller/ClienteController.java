package edu.pe.cibertec.Fastrack_DSW1_Grupo7.Controller;

import edu.pe.cibertec.Fastrack_DSW1_Grupo7.Exception.ResourceNotFoundException;
import edu.pe.cibertec.Fastrack_DSW1_Grupo7.Model.Cliente;
import edu.pe.cibertec.Fastrack_DSW1_Grupo7.Model.Empleado;
import edu.pe.cibertec.Fastrack_DSW1_Grupo7.Service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("")
    public ResponseEntity<List<Cliente>> listaClientes() {
        List<Cliente> clientesList = clienteService.listaClientes();
        if (clientesList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clientesList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable("id") Integer id) {
        Cliente cliente = clienteService.obtenerClientePorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con el ID " + id + " no existe"));
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Cliente> registrarCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.registrarCliente(cliente);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
        Cliente oldCliente = clienteService.obtenerClientePorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con el ID " +
                        id + " no existe"));
        oldCliente.setNombre(cliente.getNombre());
        oldCliente.setDireccion(cliente.getDireccion());
        oldCliente.setNumerotelefono(cliente.getNumerotelefono());
        oldCliente.setCorreoelectronico(cliente.getCorreoelectronico());
        clienteService.registrarCliente(oldCliente);
        return new ResponseEntity<>(oldCliente, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable("id") Integer id) {
        Cliente cliente = clienteService.obtenerClientePorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con el ID " + id + " no existe"));
        clienteService.eliminarCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/pornombre")
    public ResponseEntity<List<Cliente>> obtenerClientePorNombre(@RequestParam String nombre) {
        List<Cliente> clientes = clienteService.obtenerEmpleadosPorNombre(nombre);
        if (clientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
}
