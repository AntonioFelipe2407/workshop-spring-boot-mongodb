package com.moreiraf7.workshopmongo.config;

import com.moreiraf7.workshopmongo.dto.CommentDTO;
import com.moreiraf7.workshopmongo.domain.Post;
import com.moreiraf7.workshopmongo.domain.User;
import com.moreiraf7.workshopmongo.dto.AuthorDTO;
import com.moreiraf7.workshopmongo.repository.PostRepository;
import com.moreiraf7.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Antonio Felipe Moreira", "antonio@gmail.com");
        User u2 = new User(null, "Ana Clara Moreira", "aninha@gmail.com");
        User u3 = new User(null, "Liliane Moreira", "liliane@gmail.com");
        User u4 = new User(null, "Igor Moreira", "igor@gmail.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));

        Post p1 = new Post(null, Instant.now(), "Partiu Festa", "Hoje eu vou encher a cara HAHAHA", new AuthorDTO(u1));
        Post p2 = new Post(null, Instant.now(), "Partiu igreja", "Hoje eu vou rezar muito hahaha", new AuthorDTO(u2));
        Post p3 = new Post(null, Instant.now(), "Indo para Faculdade", "Hoje eu vou estudar muito kkk", new AuthorDTO(u2));

        postRepository.saveAll(Arrays.asList(p1, p2, p3));

        u1.getPosts().add(p1);
        u2.getPosts().addAll(Arrays.asList(p2, p3));

        userRepository.saveAll(Arrays.asList(u1, u2));

        CommentDTO c1 = new CommentDTO("HAHAHA também vou hoje ;)", Instant.now(), new AuthorDTO(u3));
        CommentDTO c2 = new CommentDTO("Amemmm haha", Instant.now(), new AuthorDTO(u1));
        CommentDTO c3 = new CommentDTO("VAMO CURTIR MUITO", Instant.now(), new AuthorDTO(u2));
        CommentDTO c4 = new CommentDTO("Hoje é matematica?", Instant.now(), new AuthorDTO(u1));
        CommentDTO c5 = new CommentDTO("Dia de ouvir mta musicaaaa", Instant.now(), new AuthorDTO(u3));

        p1.getComments().addAll(Arrays.asList(c1, c3, c5));
        p2.getComments().add(c2);
        p3.getComments().add(c4);

        postRepository.saveAll(Arrays.asList(p1, p2 ,p3));

    }
}
