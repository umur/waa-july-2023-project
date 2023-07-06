package com.twohundred.alumni.repository;

import com.twohundred.alumni.entity.Student;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends ListCrudRepository<Student, Long> {
}
