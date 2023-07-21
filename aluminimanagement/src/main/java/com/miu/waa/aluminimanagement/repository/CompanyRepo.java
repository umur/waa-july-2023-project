package com.miu.waa.aluminimanagement.repository;

import com.miu.waa.aluminimanagement.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company,Integer> {
}
