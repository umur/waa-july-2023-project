package com.example.geeks.repos;

import com.example.geeks.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ApplicationRepo extends JpaRepository<Application, List<Application>> {

    public List<Application> getApplicationsByStudent_IdIsAndIsDeleted(Long StudentId, boolean d);
    public Application getApplicationByAppIdIsAndIsDeleted(Long id, boolean d);


    @Modifying
    @Query(value = "UPDATE `alumni_db`.`application` SET `is_deleted` = true WHERE (`student_id` = ?1) AND (`advertisement_id` = ?2);\n",
            nativeQuery = true)
    public void deleteApplication(Long id, Long adId);
}
