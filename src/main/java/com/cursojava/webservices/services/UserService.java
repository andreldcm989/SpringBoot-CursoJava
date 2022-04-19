package com.cursojava.webservices.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.cursojava.webservices.entities.User;
import com.cursojava.webservices.repositories.UserRepository;
import com.cursojava.webservices.services.exceptions.DatabaseException;
import com.cursojava.webservices.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));//lança a exceção quando não encontra o que procurou
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);   
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj){
        try{
        User entity = repository.getById(id);
        UpdateData(entity, obj);
        return repository.save(entity);
        } catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void UpdateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }


}
//para usar uma classe com o mecanismo de injeção e dependência do framework,
//precisamos registrar essa classe como componente dele.
//No caso, para usar essa classe funcionar em outra classe usando Autowired, registrei com a anotação Service, 
//mas poderia ser Component ou Repository, dependendo da função da classe.
