package com.moreiraf7.workshopmongo.service;

import com.moreiraf7.workshopmongo.domain.Post;
import com.moreiraf7.workshopmongo.repository.PostRepository;
import com.moreiraf7.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException(id));
    }

}
