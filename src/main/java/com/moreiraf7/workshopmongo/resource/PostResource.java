package com.moreiraf7.workshopmongo.resource;


import com.moreiraf7.workshopmongo.domain.Post;
import com.moreiraf7.workshopmongo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService service;

    //Buscando um post pelo id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")         //Anotation RequestParams para dizer que a palavra sera passada na URL"
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);  //Decodifica a palavra passada
        List<Post> list = service.findByTitle(text); // Recebe a lista de posts encontrados contendo a String passada
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            //Anotation RequestParams para dizer as palavras que serao passadas na URL"
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text);//Decodifica a palavra passada
        LocalDate dateMin = URL.converterDate(minDate, LocalDate.of(1970, 1, 1)); // Convertendo a data, passando um valor padrao como default
        LocalDate dateMax = URL.converterDate(maxDate, LocalDate.now()); // Convertendo a data e passando a data atual como default
        List<Post> list = service.fullSearch(text, dateMin, dateMax); // Recebe a lista de posts contendo o texto passado, ou no titulo, ou no corpo ou nos comentarios
        return ResponseEntity.ok().body(list);
    }
}
