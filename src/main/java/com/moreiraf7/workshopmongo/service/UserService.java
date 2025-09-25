package com.moreiraf7.workshopmongo.service;

import com.moreiraf7.workshopmongo.domain.User;
import com.moreiraf7.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
}
