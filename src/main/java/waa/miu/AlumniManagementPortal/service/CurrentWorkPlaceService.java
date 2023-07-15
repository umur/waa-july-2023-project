package waa.miu.AlumniManagementPortal.service;

import waa.miu.AlumniManagementPortal.entity.CurrentWorkPlace;

import java.util.List;

public interface CurrentWorkPlaceService {

    List<CurrentWorkPlace> findAll();

    CurrentWorkPlace findById(Long id);

    CurrentWorkPlace create(CurrentWorkPlace currentWorkPlace);

    CurrentWorkPlace update(Long id, CurrentWorkPlace currentWorkPlace);

    void delete(Long id);
}
