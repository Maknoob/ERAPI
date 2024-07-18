package com.codingmak.api;

import com.codingmak.model.AshOfWar;
import com.codingmak.service.AshOfWarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ashesofwar")
public class AshOfWarController implements PpdInterface<AshOfWar> {

    @Autowired
    private AshOfWarService ashOfWarService;


    @GetMapping
    public List<AshOfWar> search(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "skill", required = false) String skill,
            @RequestParam(value = "affinity", required = false) String affinity) {
        return ashOfWarService.search(id, name, skill ,affinity);
    }

    @Override
    public AshOfWar create(AshOfWar entity) {
        return ashOfWarService.create(entity);
    }

    @Override
    public AshOfWar update(Long id, AshOfWar entity) {
        return ashOfWarService.update(id, entity);
    }

    @Override
    public void deleteById(Long id) {
        ashOfWarService.deleteById(id);
    }
}
