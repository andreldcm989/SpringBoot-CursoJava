package com.cursojava.webservices.resources;

import java.net.URI;
import java.util.List;

import com.cursojava.webservices.entities.User;
import com.cursojava.webservices.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
//a anotação PathVariable leva o atributo do método como parametro da URL
// a anotação PostMapping faz a insersão de um novo recurso no banco de dados.
// a anotação GetMapping recupera dados
//pra dizer que o objeto chegue em modo JSon na requisição, e o JSON será desserializado para o objeto em questão, usa-se o RequestBody.
//quando inserimos um recurso, o mais adequado é usar o código 201 do http. Para isso,
//usamos o método ResponseEntity.created, que espera um objeto URI, pq no http quando vamos retornar um 201,
//ele espera um cabeçalho do tipo location contendo o endereço do novo recurso inserido. forma padrão: variavel URI. 