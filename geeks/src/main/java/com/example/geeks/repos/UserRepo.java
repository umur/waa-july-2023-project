package com.example.geeks.repos;

import com.example.geeks.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;



import java.util.List;
import java.util.Optional;

@Repository

public interface UserRepo extends ListCrudRepository<User, Long> {


    Optional<User> findByEmail(String email);
    List<User> findByStateAndIsDeleted(String stateName, boolean d);
    List<User> findByCityAndIsDeleted(String cityName, boolean d);
    List<User> findByMajorAndIsDeleted(String major, boolean d);
    List<User> findByNameContainingAndIsDeleted(String name, boolean d);
    List<User> findByIdContainingAndIsDeleted(Long id, boolean d);

    List<User> findAllByIsDeleted(boolean d);

    @Modifying
    @Query(value = "UPDATE `alumni_db`.`user` SET `is_deleted` = true WHERE (`id` = ?);\n",
            nativeQuery = true)
    void updateUserByIdIs(Long id);
}
