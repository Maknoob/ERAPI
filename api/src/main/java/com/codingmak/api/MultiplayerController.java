package com.codingmak.api;

import com.codingmak.model.Multiplayer;
import com.codingmak.service.MultiplayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/multiplayer")
public class MultiplayerController {

    @Autowired
    private MultiplayerService multiplayerService;

    @GetMapping
    public List<Multiplayer> search(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "type", required = false) String type) {
        return multiplayerService.search(id, name, type);
    }


    /* @Override
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
    } */
}
