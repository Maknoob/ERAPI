package com.codingmak.api;

import com.codingmak.model.Multiplayer;
import com.codingmak.service.MultiplayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/multiplayer")
public class MultiplayerController implements BaseController<Multiplayer> {

    @Autowired
    private MultiplayerService multiplayerService;


    @Override
    public List<Multiplayer> getAll() {
        return multiplayerService.findAll();
    }

    @Override
    public Optional<Multiplayer> getById(Long id) {
        return multiplayerService.findById(id);
    }

    @Override
    public Multiplayer update(Long id, Multiplayer entity) {
        Multiplayer multiplayer = multiplayerService.findById(id)
                .orElseThrow(() -> new RuntimeException("Multiplayer Item not found"));
        multiplayer.setName(entity.getName());
        multiplayer.setType(entity.getType());
        multiplayer.setDlc(entity.getDlc());
        multiplayer.setImage(entity.getImage());
        multiplayer.setWhenUsed(entity.getWhenUsed());
        multiplayer.setLocation(entity.getLocation());
        return multiplayerService.save(multiplayer);
    }

    @Override
    public Multiplayer create(Multiplayer entity) {
        return multiplayerService.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        multiplayerService.deleteById(id);
    }
}
