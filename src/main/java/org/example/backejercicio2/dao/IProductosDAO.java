package org.example.backejercicio2.dao;

import org.example.backejercicio2.entities.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IProductosDAO  extends CrudRepository<Producto, Long> {
    @Query("SELECT p FROM Producto p ORDER BY p.idProducto")
    Iterable<Producto> findAll();
}
