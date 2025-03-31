package org.example.backejercicio2.services;

import org.example.backejercicio2.entities.Cliente;

import java.util.List;

public interface IClientesService {
    List<Cliente> findAll();
    Cliente findById(Long id);
    Cliente save(Cliente cliente);
    void delete(Long id);
}
