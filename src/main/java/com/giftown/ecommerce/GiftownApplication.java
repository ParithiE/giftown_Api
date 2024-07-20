package com.giftown.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.giftown.ecommerce.*")
@EnableJpaRepositories(basePackages = "com.giftown.ecommerce.repository")
public class GiftownApplication {

    public static void main(String[] args) {
        SpringApplication.run(GiftownApplication.class, args);
    }

}
