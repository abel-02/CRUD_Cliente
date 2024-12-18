package com.redo.CRUD_Cliente.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Data
@Table(name = "cliente")
@AllArgsConstructor
public class Cliente  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String direccion;

}
