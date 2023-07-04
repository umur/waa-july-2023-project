package com.blue.alumniMangePortal.repository;

import com.blue.alumniMangePortal.entity.Faculty;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepo extends ListCrudRepository<Faculty,Long> {
}
