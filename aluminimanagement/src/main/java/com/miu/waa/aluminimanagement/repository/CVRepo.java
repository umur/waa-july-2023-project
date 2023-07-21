package com.miu.waa.aluminimanagement.repository;

import com.miu.waa.aluminimanagement.model.CV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVRepo extends JpaRepository<CV, Integer> {

}

