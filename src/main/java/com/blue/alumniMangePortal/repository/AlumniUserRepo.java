package com.blue.alumniMangePortal.repository;

import com.blue.alumniMangePortal.entity.AlumniUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlumniUserRepo extends JpaRepository<AlumniUser, Integer> {
    Optional<AlumniUser> findByEmail(String email);
}
