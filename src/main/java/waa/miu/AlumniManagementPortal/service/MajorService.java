package waa.miu.AlumniManagementPortal.service;

import waa.miu.AlumniManagementPortal.entity.JobAdvert;
import waa.miu.AlumniManagementPortal.entity.Major;

import java.util.List;

public interface MajorService {

    List<Major> findAll();

    Major findById(Long id);

    Major create(Major major);

    Major update(Long id, Major major);

    void delete(Long id);
}
