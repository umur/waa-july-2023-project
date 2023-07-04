package com.example.alumni.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.alumni.entity.Tag;

import java.util.Optional;

public interface TagRepository extends ListCrudRepository<Tag, Long> {
    Optional<Tag> findByName(String name);

}
