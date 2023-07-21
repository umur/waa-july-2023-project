package com.miu.waa.aluminimanagement.repository;

import com.miu.waa.aluminimanagement.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepo extends JpaRepository<Tag, Integer> {
    List<Tag> findTagsByTagStartingWithIgnoreCase(String filter);
}
