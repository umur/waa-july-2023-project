package com.twohundred.alumni.repository;

import com.twohundred.alumni.entity.Tag;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepo extends ListCrudRepository<Tag, Long> {

    List<Tag> findAllByNameLike(String name);

}
