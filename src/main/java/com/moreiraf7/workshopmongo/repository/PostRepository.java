package com.moreiraf7.workshopmongo.repository;

import com.moreiraf7.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    // Query method para encontrar posts que contenham a palavra passada
    List<Post> findByTitleContainingIgnoreCase(String text);


    // Query para buscar posts contendo dado String no titulo
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

    /*
    A Query executa uma operacao logica "and" comparando o campo date, dizendo que date deve ser >= que minDate
    e que date deve ser <= maxDate.
    Apos isso a query executa uma operacao logica "or" passando as expressoes, dizendo para procurar o texto
    ou no titulo, ou no corpo ou nos comentarios
     */
    @Query("{ $and: [ { date: { $gte: ?1 }  }, { date: { $lte: ?2 } }, { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate);


}
