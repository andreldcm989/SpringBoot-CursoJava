package com.cursojava.webservices.repositories;

import com.cursojava.webservices.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
// não precisa criar a implementação, pq o springdata JPA já tem implementação padrão
// quando definimos o Generic JpaRepository usando a entidade e o tipo de ID da entidade.
//Essa interface não precisa ser registrada como componente pq já herda de JpaRepository, que é um repositório.