package com.moreiraf7.workshopmongo.service;

import com.moreiraf7.workshopmongo.domain.Post;
import com.moreiraf7.workshopmongo.repository.PostRepository;
import com.moreiraf7.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate) {
        maxDate = maxDate.plusDays(1); // Adianta um dia na frente para que o dia passado seja valido pelas suas 24h

        return repository.fullSearch(text, minDate, maxDate); // retorna a query do repositorio
    }

}
