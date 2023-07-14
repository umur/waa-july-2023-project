package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Address;
import com.blue.alumniMangePortal.entity.CurrentWorkPlace;
import com.blue.alumniMangePortal.entity.Major;

import java.util.List;
import java.util.Optional;

public interface MajorService {
     List<Major> getAll();
     Major getMajorById(Long id);
     Major saveMajor(Major major);
     Major updateMajor(long id,Major major);
    void findByDeletedTrue(Long id);

}
