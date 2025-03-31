package org.example.backejercicio2.dao;

import org.example.backejercicio2.entities.Cliente;
import org.example.backejercicio2.entities.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IClientesDAO extends CrudRepository<Cliente, Long> {
    @Query("SELECT p FROM Cliente p ORDER BY p.idCliente")
    Iterable<Cliente> findAll();
}
