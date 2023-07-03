package com.alumni.repository;

import com.alumni.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobAdvertisementRepository extends JpaRepository<Faculty,Long> {


}
