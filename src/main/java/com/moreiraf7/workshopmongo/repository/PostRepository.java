package com.moreiraf7.workshopmongo.repository;

import com.moreiraf7.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    // Query method para encontrar posts que contenham a palavra passada
    List<Post> findByTitleContainingIgnoreCase(String text);


    // Query para procurar pelo titulo
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);


}
