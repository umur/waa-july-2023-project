package com.example.alumni.service.impl;

import com.example.alumni.service.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.alumni.entity.CV;
import com.example.alumni.repository.CVRepository;

import org.springframework.data.util.Pair;

@Service
@Transactional
public class CVServiceImpl implements CVService {

    @Autowired
    private CVRepository cvRepository;

    @Override
    public Iterable<CV> getAllCVs() {
        return cvRepository.findAll();
    }

    @Override
    public CV getCVById(long id) {
        return cvRepository.findById(id).orElse(null);
    }

    @Override
    public CV createCV(CV cv) {
        return cvRepository.save(cv);
    }

    @Override
    public Pair<Boolean, CV> updateCV(CV cv) {
        boolean exists = cvRepository.existsById(cv.getId());
        cvRepository.save(cv);
        return Pair.of(exists, cv);
    }

    @Override
    public boolean deleteCV(long id) {
        CV existingCV = cvRepository.findById(id).orElse(null);
        if (existingCV != null) {
            cvRepository.delete(existingCV);
            return true;
        }
        return false;
    }
}
