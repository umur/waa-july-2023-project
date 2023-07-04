package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.CurrentWorkPlace;
import com.blue.alumniMangePortal.entity.Cv;
import com.blue.alumniMangePortal.repository.CvRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CvServiceImpl implements CvService {
    private final CvRepo cvRepo;
    public List<Cv> getAll(){
        return cvRepo.findAll();

    }
    public Cv getCvById(Long id){
        Optional<Cv> cv = cvRepo.findById(id);
        if(cv.isPresent()){
            return cv.get();
        }
        return null;

    }
    public Cv saveCv(Cv cv){
        cvRepo.save(cv);
        return cv;
    }
    public Cv updateCv(long id,Cv cv){
        Optional<Cv> c=cvRepo.findById(id);
        c.get().setAddress(cv.getAddress());
        c.get().setWorkExperience(cv.getWorkExperience());
        c.get().setEducationBackground(cv.getEducationBackground());

        cvRepo.save(c.get());
        return c.get();

    }

    public String deleteCvById(Long id){
        Optional<Cv> c= cvRepo.findById(id);
        if(c.isPresent()){
            cvRepo.deleteById(id);
        }
        return"Cv deleted";
    }
}
