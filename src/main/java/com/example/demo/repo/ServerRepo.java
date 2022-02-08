package com.example.demo.repo;

import com.example.demo.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepo extends JpaRepository<Server, Long> {
    // <T, D> T is your Model, D is primary key type

    // can easily customize to start as "find by",
    // but need to make sure your argu is unique
    // this will directly create for finding by ipAddress
    Server findByIpAddress(String ipAddress);
}
