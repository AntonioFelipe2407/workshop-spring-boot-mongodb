package com.moreiraf7.workshopmongo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.Instant;

public class CommentDTO implements Serializable {

    /*
    Considerando que nesse caso os comentarios sao dados muitos simples dentro de post, optei por não criar uma identidade,
     criando apenas um DTO, assim eu apenas instancio os comentarios e os adiciono a lista de comentarios em posts
     */

    private String text;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")

    private Instant date;
    private AuthorDTO author;


    public CommentDTO() {
    }

    public CommentDTO(String text, Instant date, AuthorDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

}
