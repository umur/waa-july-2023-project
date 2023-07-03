package com.blue.alumniMangePortal.repository;

import com.blue.alumniMangePortal.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
