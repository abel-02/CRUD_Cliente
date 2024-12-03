package com.redo.CRUD_Cliente.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity @Data @DiscriminatorValue("usuarios")
@EqualsAndHashCode(callSuper = true)
public class Usuario extends Persona{

}
