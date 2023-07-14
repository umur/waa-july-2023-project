package waa.miu.AlumniManagementPortal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import waa.miu.AlumniManagementPortal.entity.Major;
import waa.miu.AlumniManagementPortal.repository.MajorRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MajorServiceImpl implements MajorService{

    private final MajorRepo majorRepo;

    @Override
    public List<Major> findAll() {
        return majorRepo.findAll();
    }

    @Override
    public Major findById(Long id) {
        return majorRepo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Major with id "+id+" not found"));
    }

    @Override
    public Major create(Major major) {
        return majorRepo.save(major);
    }

    @Override
    public Major update(Long id, Major major) {
        Major exisitingMajor = findById(id);
        exisitingMajor.setMajorName(major.getMajorName());
        exisitingMajor.setStudents(major.getStudents());
        return majorRepo.save(exisitingMajor);
    }

    @Override
    public void delete(Long id) {
        majorRepo.deleteById(id);
    }
}
