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


    public List<Multiplayer> search(Long id, String name, String type) {
        if (id != null) {
            return multiplayerRepository.findById(id).stream().toList();
        }
        if (name != null) {
            return multiplayerRepository.findByNameContaining(name);
        }
        if (type != null) {
            return multiplayerRepository.findByTypeContaining(type);
        }
        return multiplayerRepository.findAll();
    }


    /* @Override
    public Multiplayer save(Multiplayer entity) {
        return multiplayerRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        multiplayerRepository.deleteById(id);
    } */
}
