package org.example.backejercicio2.controllers;

import org.example.backejercicio2.entities.Producto;
import org.example.backejercicio2.services.IProductosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    protected IProductosService service;
    public ProductosController(IProductosService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Producto> getAllProductos() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable(name = "id") Long id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public Producto createProducto(@RequestBody Producto producto) {
        return service.save(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable(name = "id") Long id, @RequestBody Producto producto) {
        Producto productoActual = service.findById(id);
        producto.setIdProducto(id);
        return service.save(producto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable(name = "id") Long id) {
        service.delete(id);
    }

}
