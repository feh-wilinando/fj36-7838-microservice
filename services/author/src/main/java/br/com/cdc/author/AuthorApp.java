package br.com.cdc.author;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AuthorApp {
    public static void main(String[] args) {
        SpringApplication.run(AuthorApp.class, args);
    }
}
