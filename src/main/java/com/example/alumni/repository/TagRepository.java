package com.example.alumni.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.alumni.entity.Tag;

public interface TagRepository extends ListCrudRepository<Tag, Long> {
}
