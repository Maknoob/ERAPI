package com.codingmak.service;

import com.codingmak.model.Multiplayer;
import com.codingmak.repositories.MultiplayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultiplayerService {

    @Autowired
    private MultiplayerRepository multiplayerRepository;

    public List<Multiplayer> findAllMultiplayerItems() {
        return multiplayerRepository.findAll();
    }

    public Multiplayer saveMultiplayerItem(Multiplayer multiplayer) {
        return multiplayerRepository.save(multiplayer);
    }
}
