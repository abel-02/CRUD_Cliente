package com.redo.CRUD_Cliente.dto;

import lombok.Data;

@Data
public class RequestLogin {
    private String email;
    private String password;
}
