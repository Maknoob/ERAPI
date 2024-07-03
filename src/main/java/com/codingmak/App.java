package com.codingmak;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.codingmak.*")
@EntityScan(basePackages = "com.codingmak.model")
@EnableJpaRepositories(basePackages = "com.codingmak.repositories")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
