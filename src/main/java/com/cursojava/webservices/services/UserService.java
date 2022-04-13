package com.cursojava.webservices.services;

import java.util.List;
import java.util.Optional;

import com.cursojava.webservices.entities.User;
import com.cursojava.webservices.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }


}
//para usar uma classe com o mecanismo de injeção e dependência do framework,
//precisamos registrar essa classe como componente dele.
//No caso, para usar essa classe funcionar em outra classe usando Autowired, registrei com a anotação Service, 
//mas poderia ser Component ou Repository, dependendo da função da classe.
