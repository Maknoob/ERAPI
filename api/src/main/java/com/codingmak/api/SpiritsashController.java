package com.codingmak.api;

import com.codingmak.model.Spiritsash;
import com.codingmak.service.SpiritsashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spiritsashes")
public class SpiritsashController implements PpdInterface<Spiritsash> {

    @Autowired
    private SpiritsashService spiritsashService;

    @GetMapping
    public List<Spiritsash> search(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "name", required = false) String name) {
        return spiritsashService.search(id, name);
    }


    @Override
    public Spiritsash create(Spiritsash entity) {
        return spiritsashService.create(entity);
    }

    @Override
    public Spiritsash update(Long id, Spiritsash entity) {
        return spiritsashService.update(id, entity);
    }

    @Override
    public void deleteById(Long id) {
        spiritsashService.deleteById(id);
    }
}