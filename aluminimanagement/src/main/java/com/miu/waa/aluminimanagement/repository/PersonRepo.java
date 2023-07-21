package com.miu.waa.aluminimanagement.repository;

import com.miu.waa.aluminimanagement.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
    Person findPersonByUsernameIgnoreCase(String username);
}
