package com.example.alumni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.alumni.entity.CV;
import com.example.alumni.repository.CVRepository;

import org.springframework.data.util.Pair;

@Service
@Transactional
public class CVService {

    @Autowired
    private CVRepository cvRepository;

    public Iterable<CV> getAllCVs() {
        return cvRepository.findAll();
    }

    public CV getCVById(long id) {
        return cvRepository.findById(id).orElse(null);
    }

    public CV createCV(CV cv) {
        return cvRepository.save(cv);
    }

    public Pair<Boolean, CV> updateCV(CV cv) {
        boolean exists = cvRepository.existsById(cv.getCV_id());
        cvRepository.save(cv);
        return Pair.of(exists, cv);
    }

    public boolean deleteCV(long id) {
        CV existingCV = cvRepository.findById(id).orElse(null);
        if (existingCV != null) {
            cvRepository.delete(existingCV);
            return true;
        }
        return false;
    }
}
