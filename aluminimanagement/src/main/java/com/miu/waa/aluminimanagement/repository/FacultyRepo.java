package com.miu.waa.aluminimanagement.repository;

import com.miu.waa.aluminimanagement.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepo extends JpaRepository<Faculty,Integer> {
}
