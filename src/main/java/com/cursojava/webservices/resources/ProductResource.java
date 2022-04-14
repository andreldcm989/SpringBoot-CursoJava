package com.cursojava.webservices.resources;

import java.util.List;

import com.cursojava.webservices.entities.Product;
import com.cursojava.webservices.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/products")//nome do recurso
public class ProductResource {

    @Autowired
    private ProductService service;
    
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list  = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
//a anotação PathVariable leva o atributo do método como parametro da URL