package com.moreiraf7.workshopmongo.resource;


import com.moreiraf7.workshopmongo.domain.Post;
import com.moreiraf7.workshopmongo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/titleserch")         //Anotation RequestParams para dizer que a palavra sera passada na URL"
    public ResponseEntity<List<Post>> findByWord(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);  //Decodifica a palavra passada
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
