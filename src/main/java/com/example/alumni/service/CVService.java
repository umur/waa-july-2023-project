package com.example.alumni.service;

import com.example.alumni.entity.CV;
import org.springframework.data.util.Pair;

public interface CVService {
    Iterable<CV> getAllCVs();

    CV getCVById(long id);

    CV createCV(CV cv);

    Pair<Boolean, CV> updateCV(CV cv);

    boolean deleteCV(long id);
}
