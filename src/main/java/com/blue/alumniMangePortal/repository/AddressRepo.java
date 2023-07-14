package com.blue.alumniMangePortal.repository;

import com.blue.alumniMangePortal.entity.Address;
import com.blue.alumniMangePortal.entity.JobsAdvertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends JpaRepository<Address,Long> {
    @Query("SELECT a FROM Address a WHERE a.isDeleted = false")
    List<Address> getAll();
}
