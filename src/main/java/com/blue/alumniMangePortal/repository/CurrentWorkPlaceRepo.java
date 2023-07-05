package com.blue.alumniMangePortal.repository;

import com.blue.alumniMangePortal.entity.CurrentWorkPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentWorkPlaceRepo extends JpaRepository<CurrentWorkPlace,Long> {
}
