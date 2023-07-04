package com.example.geeks.services;


import com.example.geeks.entity.User;
import com.example.geeks.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Qualifier("uss")
@Component
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
        return usRepo.findById(id);
    }

    public List<User> getUsersWhereIdHas(Long id){
        return usRepo.findByIdContaining(id);
    }

    public List<User> getUsersByCity(String city){
        return usRepo.findByCity(city);
    }

    public List<User> getUsersByState(String state){
        return usRepo.findByState(state);
    }
/////////////////////////////////
    public List<User> getUsersWhereNameHas(String name){
        return usRepo.findByNameContaining(name);
    }

    public List<User> getStudentByMajor(String major){
        return usRepo.findByMajor(major);
    }
//////////////////////////////////



}
