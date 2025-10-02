package com.moreiraf7.workshopmongo.repository;

import com.moreiraf7.workshopmongo.domain.Post;
import com.moreiraf7.workshopmongo.dto.CommentDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    // Query method para encontrar posts que contenham a palavra passada
    public List<Post> findByTitleContainingIgnoreCase(String text);

}
