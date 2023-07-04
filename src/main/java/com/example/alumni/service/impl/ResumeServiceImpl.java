package com.example.alumni.service.impl;

import com.example.alumni.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.alumni.entity.Resume;
import com.example.alumni.repository.ResumeRepository;

import org.springframework.data.util.Pair;

@Service
@Transactional
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Override
    public Iterable<Resume> getAllCVs() {
        return resumeRepository.findAll();
    }

    @Override
    public Resume getCVById(long id) {
        return resumeRepository.findById(id).orElse(null);
    }

    @Override
    public Resume createCV(Resume resume) {
        return resumeRepository.save(resume);
    }

    @Override
    public Pair<Boolean, Resume> updateCV(Resume resume) {
        boolean exists = resumeRepository.existsById(resume.getId());
        resumeRepository.save(resume);
        return Pair.of(exists, resume);
    }

    @Override
    public boolean deleteCV(long id) {
        Resume existingResume = resumeRepository.findById(id).orElse(null);
        if (existingResume != null) {
            resumeRepository.delete(existingResume);
            return true;
        }
        return false;
    }
}
