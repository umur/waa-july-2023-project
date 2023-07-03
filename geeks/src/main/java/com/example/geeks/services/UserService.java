package com.example.geeks.services;


import com.example.geeks.entity.User;
import com.example.geeks.repos.UserRepo;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserService {
    private final UserRepo usRepo;

    public User addUser(User u){
        return usRepo.save(u);
    }
    public List<User> getAllUsers(){
        return usRepo.findAll();
    }

    public User getUser(Long id){
        return usRepo.getUsersById(id);
    }

    public List<User> getUsersWhereIdHas(Long id){
        return usRepo.getUsersByIdLike(id);
    }

    public List<User> getUsersByCity(String city){
        return usRepo.getUsersByCityIs(city);
    }

    public List<User> getUsersByState(String state){
        return usRepo.getUsersByStateIs(state);
    }
/////////////////////////////////
    public List<User> getUsersWhereNameHas(String name){
        return usRepo.getUsersByNameLike(name);
    }

    public List<User> getStudentByMajor(String major){
        return usRepo.getUsersByMajorIs(major);
    }
//////////////////////////////////



}
