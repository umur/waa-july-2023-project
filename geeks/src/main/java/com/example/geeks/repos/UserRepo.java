package com.example.geeks.repos;

import com.example.geeks.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {



    public Optional<User> findById(Long id);
    public List<User> findByStateAndIsDeleted(String stateName, boolean d);
    public List<User> findByCityAndIsDeleted(String cityName, boolean d);
    public List<User> findByMajorAndIsDeleted(String major, boolean d);
    public List<User> findByNameContainingAndIsDeleted(String name, boolean d);
    public List<User> findByIdContainingAndIsDeleted(Long id, boolean d);

    public List<User> findAllByIsDeleted(boolean d);

    @Modifying
    @Query(value = "UPDATE `alumni_db`.`user` SET `is_deleted` = true WHERE (`id` = ?);\n",
            nativeQuery = true)
    public void updateUserByIdIs(Long id);
}
