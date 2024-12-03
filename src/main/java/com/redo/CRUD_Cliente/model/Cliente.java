package com.redo.CRUD_Cliente.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity @Data @AllArgsConstructor
@DiscriminatorValue("clientes")
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Persona{
}
