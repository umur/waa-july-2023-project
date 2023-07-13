package com.example.alumni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.util.Pair;

public interface BaseService<T, ID> {
    Iterable<T> getAll();

    T getById(ID id);

    T add(T t) throws IllegalAccessException;

    Pair<Boolean, T> update(T t) throws IllegalAccessException;

    boolean delete(ID id) throws IllegalAccessException;
}
