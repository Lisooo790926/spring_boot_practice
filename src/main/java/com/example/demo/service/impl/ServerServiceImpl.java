package com.example.demo.service.impl;

import com.example.demo.enumeration.Status;
import com.example.demo.model.Server;
import com.example.demo.repo.ServerRepo;
import com.example.demo.service.ServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

@RequiredArgsConstructor // this will auto create the contructor
@Service
@Transactional
@Slf4j // put the log for this class
public class ServerServiceImpl implements ServerService {
    private final ServerRepo serverRepo;

    @Override
    public Server create(Server server) {
        log.info("saving new server: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return serverRepo.save(server);
    }

    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("pint server ip {}", ipAddress);
        Server server = serverRepo.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(2000) ? Status.SERVER_UP : Status.SERVER_DOWN);
        serverRepo.save(server);
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("fetching all servers");
        // can get limit page based on below method
        return serverRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Server get(Long id) {
        log.info("fetching server by id");
        return serverRepo.findById(id).get();
    }

    @Override
    public Server update(Server server) {
        log.info("updating server {}", server.getName());
        serverRepo.save(server);
        return server;
    }

    @Override
    public Boolean delete(Long id) {
        log.info("removing server {}", id);
        serverRepo.deleteById(id);
        return true;
    }

    private String setServerImageUrl() {
        String[] imageNames = {"server.1.png", "server.2.png", "server.3.png", "server.4.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image" + imageNames[new Random().nextInt(4)]).toUriString();
    }
}
