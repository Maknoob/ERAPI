package com.codingmak.service;

import com.codingmak.model.Multiplayer;
import com.codingmak.repositories.MultiplayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MultiplayerService {

    @Autowired
    private MultiplayerRepository multiplayerRepository;

    @Autowired
    private UniqueIdChecker uniqueIdChecker;

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

    public Multiplayer create(Multiplayer entity) {
        if (entity.getId() != null) {
            uniqueIdChecker.checkUniqueId(entity.getId());
        }
        return save(entity);
    }

    public Multiplayer save(Multiplayer entity) {
        return multiplayerRepository.save(entity);
    }

    public void deleteById(Long id) {
        multiplayerRepository.deleteById(id);
    }

    public Multiplayer update(Long id, Multiplayer entity) {
        Multiplayer multiplayer = multiplayerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Multiplayer Item not found"));
        multiplayer.setName(entity.getName());
        multiplayer.setType(entity.getType());
        multiplayer.setDlc(entity.getDlc());
        multiplayer.setImage(entity.getImage());
        multiplayer.setWhenUsed(entity.getWhenUsed());
        multiplayer.setLocation(entity.getLocation());
        return save(multiplayer);
    }
}
