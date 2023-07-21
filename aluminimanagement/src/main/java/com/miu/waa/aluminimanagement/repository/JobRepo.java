package com.miu.waa.aluminimanagement.repository;

import com.miu.waa.aluminimanagement.model.Job;
import com.miu.waa.aluminimanagement.model.dto.JobCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<Job, Integer> {
    List<Job> findByAddress_StateIgnoreCase(String state);
    List<Job> findByAddress_StateIgnoreCaseAndAddress_CityContainingIgnoreCase(String state, String city);
    List<Job> findByCompany_NameContainingIgnoreCase(String companyName);
    List<Job> findByStudent_Id(int studentId);
    Page<Job> findAll(Pageable pageable);
    List<Job> findJobsByTags_TagEquals(String tag);
    @Query(value =
            "SELECT "+
                    " new com.miu.waa.aluminimanagement.model.dto.JobCount(count(j.id), j.address.city, j.address.state)" +
                    "FROM Job j inner join Address as a on j.address.id=a.id " +
                    "GROUP By j.address.city,j.address.state"
    )
    List<JobCount> noOfJobsPerAddress();
}
