package com.codingmak.service;

import com.codingmak.model.Multiplayer;
import com.codingmak.repositories.MultiplayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MultiplayerService implements BaseService<Multiplayer> {

    @Autowired
    private MultiplayerRepository multiplayerRepository;

    @Override
    public List<Multiplayer> findAll() {
        return multiplayerRepository.findAll();
    }

    @Override
    public Optional<Multiplayer> findById(Long id) {
        return multiplayerRepository.findById(id);
    }

    @Override
    public List<Multiplayer> search(Long id, String name, String type) {
        return List.of();
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
