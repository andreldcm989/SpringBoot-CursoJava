package com.cursojava.webservices.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(Object id){
        super("Resource not found. Id " + id);
    }
}

//essa classe lança a exceção para quando o id não foi encontrado na requisição.
