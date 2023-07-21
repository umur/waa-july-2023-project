package com.twohundred.alumni.repository;

import com.twohundred.alumni.entity.Experience;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepo extends ListCrudRepository<Experience, Long> {
    @Query(value = "SELECT * FROM experience WHERE user_id = :id",
            nativeQuery = true)
    List<Experience> findAllByUserId(@Param("id") Long id);

}
