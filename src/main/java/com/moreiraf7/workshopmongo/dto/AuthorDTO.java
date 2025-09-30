package com.moreiraf7.workshopmongo.dto;

import com.moreiraf7.workshopmongo.domain.User;

import java.io.Serializable;

/*
  AuthorDTO projeta os dados da Entidade User (apenas, name e email)
 */

public class AuthorDTO implements Serializable {

    private String id;
    private String name;

    public AuthorDTO() {
    }

    public AuthorDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
    }

    public String getName() {
        return id;
    }

    public void setName(String id) {
        this.id = id;
    }

    public String getEmail() {
        return name;
    }

    public void setEmail(String name) {
        this.name = name;
    }
}
