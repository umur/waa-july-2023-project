package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.CurrentWorkPlace;
import com.blue.alumniMangePortal.repository.CurrentWorkPlaceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrentWorkPlaceServiceImpl implements CurrentWorkPlaceService {
    private final CurrentWorkPlaceRepo currentWorkPlaceRepo;
    public List<CurrentWorkPlace> getAll(){
        return currentWorkPlaceRepo.findAll();
    }

    public CurrentWorkPlace getCurrentWorkPlaceById(Long id){
        Optional<CurrentWorkPlace> currentWorkPlace= currentWorkPlaceRepo.findById(id);
        if(currentWorkPlace.isPresent()){
            return currentWorkPlace.get();
        }
        return null;

    }
    public CurrentWorkPlace saveCurrentWorkPlace(CurrentWorkPlace currentWorkPlace){
        currentWorkPlaceRepo.save(currentWorkPlace);
        return currentWorkPlace;
    }
    public CurrentWorkPlace updateCurrentWorkPlace(long id,CurrentWorkPlace currentWorkPlace){
        Optional<CurrentWorkPlace> current=currentWorkPlaceRepo.findById(id);
        current.get().setAddress(currentWorkPlace.getAddress());
        current.get().setPosition(currentWorkPlace.getPosition());
        current.get().setCompanyName(currentWorkPlace.getCompanyName());

        currentWorkPlaceRepo.save(current.get());
        return current.get();

    }

    public String DeleteCurrentWorkPlaceById(Long id){
        Optional<CurrentWorkPlace> current= currentWorkPlaceRepo.findById(id);
        if(current.isPresent()){
            currentWorkPlaceRepo.deleteById(id);
        }
        return"currentWorkPlace deleted";
    }

}
