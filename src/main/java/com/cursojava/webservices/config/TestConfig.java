package com.cursojava.webservices.config;

import java.util.Arrays;

import com.cursojava.webservices.entities.User;
import com.cursojava.webservices.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(u1, u2));
    }

}
// a annotation Configuration fala para o Spring que essa é uma classe
// especifica de config
// a annotation Profile indica para o Spring rodar essa config quando,
// no arquivo application.properties, tiver o mesmo atributo do Profile.
// Autowired associa uma instancia do Objeto mencionado nesta classe. O Spring,
// ao rodar a aplicação, resolve a dependencia e associa uma instancia do objeto
// aqui, dispensando o acoplamento manual.
