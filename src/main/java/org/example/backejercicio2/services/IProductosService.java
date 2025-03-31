package org.example.backejercicio2.services;

import org.example.backejercicio2.entities.Producto;

import java.util.List;

public interface IProductosService {
    List<Producto> findAll();
    Producto findById(Long id);
    Producto save(Producto producto);
    void delete(Long id);
}
