package br.com.cdc.buyer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BuyerApp {
    public static void main(String[] args) {
        SpringApplication.run(BuyerApp.class, args);
    }
}
