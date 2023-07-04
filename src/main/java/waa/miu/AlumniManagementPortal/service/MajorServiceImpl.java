package waa.miu.AlumniManagementPortal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import waa.miu.AlumniManagementPortal.entity.Major;
import waa.miu.AlumniManagementPortal.repository.MajorRepo;

import java.util.List;
import java.util.Optional;

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
        return majorRepo.findById(id).orElse(null);
    }

    @Override
    public Major create(Major major) {
        return majorRepo.save(major);
    }

    @Override
    public Major update(Long id, Major major) {
        Optional<Major> optionalMajor = majorRepo.findById(id);
        if (optionalMajor.isPresent()){
            optionalMajor.get().setMajorName(major.getMajorName());
            optionalMajor.get().setStudents(major.getStudents());
        }
        return optionalMajor.orElse(null);
    }

    @Override
    public void delete(Long id) {
        majorRepo.deleteById(id);
    }
}
