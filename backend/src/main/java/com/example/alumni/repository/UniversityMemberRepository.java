package com.example.alumni.repository;

import com.example.alumni.entity.UniversityMember;
import com.example.alumni.entity.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UniversityMemberRepository extends ListCrudRepository<UniversityMember, Long> {
    Optional<UniversityMember> findByEmail(String email);
}
