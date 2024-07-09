package com.codingmak.api;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface BaseController<T> {

    @GetMapping
    List<T> getAll();

    @GetMapping("/search")
    Optional<T> getById(@RequestParam("id") Long id);

    @PutMapping
    T update(@RequestParam("id") Long id, @RequestBody T entity);

    @PostMapping
    T create(@RequestBody T entity);

    @DeleteMapping
    void deleteById(@RequestParam("delete") Long id);

}
