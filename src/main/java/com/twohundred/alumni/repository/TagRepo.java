package com.twohundred.alumni.repository;

import com.twohundred.alumni.entity.Tag;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepo extends ListCrudRepository<Tag, Long> {
}
