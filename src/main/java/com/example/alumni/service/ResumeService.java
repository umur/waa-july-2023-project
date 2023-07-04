package com.example.alumni.service;

import com.example.alumni.entity.Resume;
import org.springframework.data.util.Pair;

public interface ResumeService {
    Iterable<Resume> getAllCVs();

    Resume getCVById(long id);

    Resume createCV(Resume resume);

    Pair<Boolean, Resume> updateCV(Resume resume);

    boolean deleteCV(long id);
}
