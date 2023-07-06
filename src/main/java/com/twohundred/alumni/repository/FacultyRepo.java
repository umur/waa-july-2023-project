package com.twohundred.alumni.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.twohundred.alumni.entity.Faculty;

public interface FacultyRepo extends ListCrudRepository<Faculty, Long> {

}
