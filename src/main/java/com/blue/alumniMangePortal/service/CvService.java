package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.CurrentWorkPlace;
import com.blue.alumniMangePortal.entity.Cv;

import java.util.List;
import java.util.Optional;

public interface CvService {
    public List<Cv> getAll();
    public Cv getCvById(Long id);
    public Cv saveCv(Cv cv);
    public Cv updateCv(long id,Cv cv);

    public String deleteCvById(Long id);
}
