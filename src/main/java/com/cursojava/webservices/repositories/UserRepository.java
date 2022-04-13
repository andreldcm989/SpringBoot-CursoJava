package com.cursojava.webservices.repositories;

import com.cursojava.webservices.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    //não precisa criar a implementação, pq o springdata JPA já tem implementação padrão 
    //quando definimos o Generic JpaRepository usando a entidade e o tipo de ID da entidade.
}
