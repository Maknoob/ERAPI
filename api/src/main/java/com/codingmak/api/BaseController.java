package com.codingmak.api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BaseController<T> {

    @GetMapping
    List<T> search(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "type", required = false) String type);

    @PutMapping
    T update(@RequestParam("id") Long id, @RequestBody T entity);

    @PostMapping
    T create(@RequestBody T entity);

    @DeleteMapping
    void deleteById(@RequestParam("delete") Long id);

}
