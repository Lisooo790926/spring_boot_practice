package com.example.demo;

import com.example.demo.enumeration.Status;
import com.example.demo.model.Server;
import com.example.demo.repo.ServerRepo;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    // after running after initialize server
    CommandLineRunner run(ServerRepo serverRepo) {
        return args -> {
            serverRepo.save(new Server(null, "192.160.1.160", "Ubuntu Linux", "16 GB", "Personal PC", "http://localhost:8080/server/images/server1.jpg", Status.SERVER_UP));
            serverRepo.save(new Server(null, "192.160.1.58", "Fedora Linux", "16 GB", "Dell Tower", "http://localhost:8080/server/images/server2.jpg", Status.SERVER_DOWN));
            serverRepo.save(new Server(null, "192.160.1.21", "MS Linux", "32 GB", "Web Server", "http://localhost:8080/server/images/server3.jpg", Status.SERVER_UP));
            serverRepo.save(new Server(null, "192.160.1.14", "Red Hat Linux", "64 GB", "Mail Server", "http://localhost:8080/server/images/server4.jpg", Status.SERVER_DOWN));
        };
    }
}
