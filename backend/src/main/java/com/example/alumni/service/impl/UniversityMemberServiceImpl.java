package com.example.alumni.service.impl;

import com.example.alumni.entity.UniversityMember;
import com.example.alumni.repository.UniversityMemberRepository;
import com.example.alumni.service.UniversityMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UniversityMemberServiceImpl implements UniversityMemberService {

    @Autowired
    private UniversityMemberRepository universityMemberRepository;

    @Override
    public Iterable<UniversityMember> getAll() {
        return universityMemberRepository.findAll();
    }

    @Override
    public UniversityMember getById(Long id) {
        return universityMemberRepository.findById(id).orElse(null);
    }

    @Override
    public UniversityMember add(UniversityMember universityMember) throws IllegalAccessException {

        throw new IllegalAccessException("Access Denied");
    }

    @Override
    public Pair<Boolean, UniversityMember> update(UniversityMember universityMember) throws IllegalAccessException {
        throw new IllegalAccessException("Access Denied");
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Optional<UniversityMember> getByEmail(String email) {
        return universityMemberRepository.findByEmail(email);
    }
}
