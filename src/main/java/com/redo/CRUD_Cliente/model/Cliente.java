package com.redo.CRUD_Cliente.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor@AllArgsConstructor
@Table(name = "clientes")
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Persona{
}
