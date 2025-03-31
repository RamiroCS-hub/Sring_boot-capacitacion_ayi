package org.example.backejercicio2.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "nombre_cliente", nullable = false)
    private String nombreCliente;

    @Column(name = "apellido_cliente", nullable = false)
    private String apellidoCliente;

    @Column(name = "fecha_ingreso")
    private String fechaIngreso;

    @Column(name = "telefono_cliente")
    private String telefonoCliente;

    @Column(name = "direccion_cliente")
    private String direccionCliente;

}