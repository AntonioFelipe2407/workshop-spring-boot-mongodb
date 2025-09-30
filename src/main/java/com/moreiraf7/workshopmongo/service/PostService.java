package com.moreiraf7.workshopmongo.service;

import com.moreiraf7.workshopmongo.domain.Post;
import com.moreiraf7.workshopmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll() {
        return repository.findAll();
    }

}
