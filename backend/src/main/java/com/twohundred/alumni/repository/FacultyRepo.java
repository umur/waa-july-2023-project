package com.twohundred.alumni.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.twohundred.alumni.entity.Faculty;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepo extends ListCrudRepository<Faculty, Long> {

}
