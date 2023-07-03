package com.example.geeks.repos;

import com.example.geeks.entity.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface UserRepo extends ListCrudRepository<User, List<User>> {

    public User getUsersById(Long id);
    public List<User> getUsersByStateIs(String stateName);
    public List<User> getUsersByCityIs(String cityName);
    public List<User> getUsersByMajorIs(String major);
    public List<User> getUsersByNameLike(String name);
    public List<User> getUsersByIdLike(Long id);
}
