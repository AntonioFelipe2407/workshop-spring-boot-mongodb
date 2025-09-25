package com.moreiraf7.workshopmongo.config;

import com.moreiraf7.workshopmongo.domain.User;
import com.moreiraf7.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User u1 = new User(null, "Antonio Felipe Moreira", "antonio@gmail.com");
        User u2 = new User(null, "Ana Clara Moreira", "aninha@gmail.com");
        User u3 = new User(null, "Liliane Moreira", "liliane@gmail.com");
        User u4 = new User(null, "Igor Moreira", "igor@gmail.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
    }
}
