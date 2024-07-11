package com.codingmak.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {

    List<T> findAll();

    Optional<T> findById(Long id);

    List<T> search(Long id, String name, String type);

    T save(T entity);

    void deleteById(Long id);

}
