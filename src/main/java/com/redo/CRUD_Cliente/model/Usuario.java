package com.redo.CRUD_Cliente.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity @Data @Table(name = "usuarios")
@EqualsAndHashCode(callSuper = true)
public class Usuario extends Persona{

}
