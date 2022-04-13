package com.cursojava.webservices.resources;

import java.util.List;

import com.cursojava.webservices.entities.User;
import com.cursojava.webservices.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")//nome do recurso
public class UserResource {

    @Autowired
    private UserService service;
    
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list  = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
//a anotação PathVariable leva o atributo do método como parametro da URL