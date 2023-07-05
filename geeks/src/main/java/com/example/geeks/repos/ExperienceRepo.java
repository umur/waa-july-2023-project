package com.example.geeks.repos;

import com.example.geeks.entity.Experience;
import com.example.geeks.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ExperienceRepo extends JpaRepository<Experience, Long> {

    List<Experience> getExperiencesByUser_IdAndIsDeleted(Long userId, boolean d);

    List<Experience> getExperiencesByCompanyNameAndIsDeleted(String companyName, boolean d);

    Experience getExperienceById(Long experienceId);

    @Modifying
    @Query(value = "UPDATE `alumni_db`.`experience` SET `is_deleted` = true WHERE (`user_id` = ?1) AND (`company_name` = ?2);\n",
            nativeQuery = true)
    public void deleteExperience(Long id, String cName);
}
