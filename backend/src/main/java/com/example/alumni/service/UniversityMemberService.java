package com.example.alumni.service;

import com.example.alumni.entity.UniversityMember;

import java.util.Optional;

public interface UniversityMemberService extends BaseService<UniversityMember, Long>{
    Optional<UniversityMember> getByEmail(String email);
}
