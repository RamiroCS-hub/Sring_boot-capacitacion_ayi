package org.example.backejercicio2.services;

import org.example.backejercicio2.dao.IProductosDAO;
import org.example.backejercicio2.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosService implements IProductosService{

    @Autowired
    IProductosDAO repository;

    @Override
    public List<Producto> findAll() {
        return (List<Producto>) repository.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
