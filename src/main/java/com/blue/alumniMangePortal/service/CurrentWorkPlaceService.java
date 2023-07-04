package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Address;
import com.blue.alumniMangePortal.entity.CurrentWorkPlace;

import java.util.List;

public interface CurrentWorkPlaceService {
    public List<CurrentWorkPlace> getAll();
    public CurrentWorkPlace getCurrentWorkPlaceById(Long id);
    public CurrentWorkPlace saveCurrentWorkPlace(CurrentWorkPlace currentWorkPlace);
    public CurrentWorkPlace updateCurrentWorkPlace(long id,CurrentWorkPlace currentWorkPlace);
    public String DeleteCurrentWorkPlaceById(Long id);

}
