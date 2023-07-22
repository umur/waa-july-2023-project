package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.JobsAdvertise;
import com.blue.alumniMangePortal.entity.Major;
import com.blue.alumniMangePortal.repository.MajorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MajorServiceImpl implements MajorService {
    private final MajorRepo majorRepo;

    public List<Major> getAll(){
        return majorRepo.findAll();

    }
    public Major getMajorById(Long id){
        Optional<Major> major=majorRepo.findById(id);
        if(major.isPresent()){
            return major.get();
        }
        return null;

    }
    public Major saveMajor(Major major){
        Major major1=new Major();
        major1.setName(major.getName());
        major1.setDuration(major.getDuration());

        majorRepo.save(major1);
        return major1;
    }
    public Major updateMajor(long id,Major major){
        Optional<Major> major1 = majorRepo.findById(id);
        major1.get().setDuration(major.getDuration());
        major1.get().setName(major.getName());

        majorRepo.save(major1.get());
        return major1.get();

    }

    public void findByDeletedTrue(Long id){
        Optional<Major>majorToDelete=majorRepo.findById(id);
        majorToDelete.get().setDeleted(true);
        majorRepo.save(majorToDelete.get());
    }


}