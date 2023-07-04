package com.blue.alumniMangePortal.controller;

import com.blue.alumniMangePortal.entity.Address;
import com.blue.alumniMangePortal.entity.CurrentWorkPlace;
import com.blue.alumniMangePortal.service.CurrentWorkPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currentWorkPlaces")
@RequiredArgsConstructor
public class CurrentWorkPlaceController {
    private final CurrentWorkPlaceService currentWorkPlaceService;
    @PostMapping
    public CurrentWorkPlace addCurrentWorkPlace(CurrentWorkPlace currentWorkPlace){
        currentWorkPlaceService.saveCurrentWorkPlace(currentWorkPlace);
        return currentWorkPlace;
    }
    @GetMapping
    public List<CurrentWorkPlace> getAll(@RequestBody CurrentWorkPlace currentWorkPlace){
        return currentWorkPlaceService.getAll();

    }
    @GetMapping("/{id}")
    public CurrentWorkPlace getById(@PathVariable Long id){
        return currentWorkPlaceService.getCurrentWorkPlaceById(id);
    }
    @PutMapping("/{id}")
    public CurrentWorkPlace updateAddress(@PathVariable Long id,@RequestBody CurrentWorkPlace currentWorkPlace){
        return currentWorkPlaceService.updateCurrentWorkPlace(id,currentWorkPlace);
    }
    @DeleteMapping("/{id}")
    public boolean deletById(@PathVariable Long id){
        currentWorkPlaceService.DeleteCurrentWorkPlaceById(id);
        return  true;
    }
}
