package com.codingmak.api;

import org.springframework.web.bind.annotation.*;

public interface PpdInterface<T> {

    @PostMapping
    T create(@RequestBody T entity);

    @PutMapping
    T update(@RequestParam(value = "update") Long id, @RequestBody T entity);

    @DeleteMapping
    void deleteById(@RequestParam(value = "del") Long id);

}
