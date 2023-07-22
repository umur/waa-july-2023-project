package com.twohundred.alumni.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.twohundred.alumni.entity.CV;
import com.twohundred.alumni.entity.CVId;

public interface CVRepo extends ListCrudRepository<CV, CVId> {

}
