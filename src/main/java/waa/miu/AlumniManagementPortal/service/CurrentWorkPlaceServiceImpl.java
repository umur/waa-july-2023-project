package waa.miu.AlumniManagementPortal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import waa.miu.AlumniManagementPortal.entity.CurrentWorkPlace;
import waa.miu.AlumniManagementPortal.repository.CurrentWorkPlaceRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrentWorkPlaceServiceImpl implements CurrentWorkPlaceService{

    private final CurrentWorkPlaceRepo currentWorkPlaceRepo;

    @Override
    public List<CurrentWorkPlace> findAll() {
        return currentWorkPlaceRepo.findAll();
    }

    @Override
    public CurrentWorkPlace findById(Long id) {
        return currentWorkPlaceRepo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Current work place with id "+id+" not found"));
    }

    @Override
    public CurrentWorkPlace create(CurrentWorkPlace currentWorkPlace) {
        return currentWorkPlaceRepo.save(currentWorkPlace);
    }

    @Override
    public CurrentWorkPlace update(Long id, CurrentWorkPlace currentWorkPlace) {
        CurrentWorkPlace existingWorkPlace = findById(id);
        existingWorkPlace.setCompanyName(currentWorkPlace.getCompanyName());
        existingWorkPlace.setPosition(currentWorkPlace.getPosition());
        existingWorkPlace.setAddress(currentWorkPlace.getAddress());
        return currentWorkPlaceRepo.save(existingWorkPlace);
    }

    @Override
    public void delete(Long id) {
        currentWorkPlaceRepo.deleteById(id);
    }
}
