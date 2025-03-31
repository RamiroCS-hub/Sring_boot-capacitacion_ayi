package org.example.backejercicio2.services;

import org.example.backejercicio2.dao.IClientesDAO;
import org.example.backejercicio2.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesService implements IClientesService{

    @Autowired
    protected IClientesDAO repository;

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) repository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
