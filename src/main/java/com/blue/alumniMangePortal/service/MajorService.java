package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Address;
import com.blue.alumniMangePortal.entity.CurrentWorkPlace;
import com.blue.alumniMangePortal.entity.Major;

import java.util.List;
import java.util.Optional;

public interface MajorService {
    public List<Major> getAll();
    public Major getMajorById(Long id);
    public Major saveMajor(Major major);
    public Major updateMajor(long id,Major major);
    public boolean  DeleteMajorById(Long id);

}
