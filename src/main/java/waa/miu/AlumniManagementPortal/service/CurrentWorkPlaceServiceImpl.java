package waa.miu.AlumniManagementPortal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import waa.miu.AlumniManagementPortal.entity.CurrentWorkPlace;
import waa.miu.AlumniManagementPortal.repository.CurrentWorkPlaceRepo;

import java.util.List;
import java.util.Optional;

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
        return currentWorkPlaceRepo.findById(id).orElse(null);
    }

    @Override
    public CurrentWorkPlace create(CurrentWorkPlace currentWorkPlace) {
        return currentWorkPlaceRepo.save(currentWorkPlace);
    }

    @Override
    public CurrentWorkPlace update(Long id, CurrentWorkPlace currentWorkPlace) {
        Optional<CurrentWorkPlace> optionalCurrentWorkPlace = currentWorkPlaceRepo.findById(id);
        if (optionalCurrentWorkPlace.isPresent()){
            optionalCurrentWorkPlace.get().setCompanyName(currentWorkPlace.getCompanyName());
            optionalCurrentWorkPlace.get().setPosition(currentWorkPlace.getPosition());
            optionalCurrentWorkPlace.get().setAddress(currentWorkPlace.getAddress());
        }
        return optionalCurrentWorkPlace.orElse(null);
    }

    @Override
    public void delete(Long id) {
        currentWorkPlaceRepo.deleteById(id);
    }
}
