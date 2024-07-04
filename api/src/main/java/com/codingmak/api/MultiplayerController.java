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
    public List<Multiplayer> getAllMultiplayerItems() {
        return multiplayerService.findAllMultiplayerItems();
    }

    @PostMapping
    public Multiplayer createMultiplayerItem(@RequestBody Multiplayer multiplayer) {
        return multiplayerService.saveMultiplayerItem(multiplayer);
    }
}
