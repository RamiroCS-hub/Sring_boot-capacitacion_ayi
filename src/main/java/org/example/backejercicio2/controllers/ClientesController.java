package org.example.backejercicio2.controllers;

import org.example.backejercicio2.entities.Cliente;
import org.example.backejercicio2.services.IClientesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    protected IClientesService service;

    public ClientesController(IClientesService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Cliente> getAllClientes() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable(name = "id") Long id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return service.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable(name = "id") Long id, @RequestBody Cliente cliente) {
        Cliente clienteActual = service.findById(id);
        cliente.setIdCliente(id);
        return service.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable(name = "id") Long id) {
        service.delete(id);
    }
}
