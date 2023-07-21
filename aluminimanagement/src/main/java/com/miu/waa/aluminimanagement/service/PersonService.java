package com.miu.waa.aluminimanagement.service;

import com.miu.waa.aluminimanagement.model.Address;
import com.miu.waa.aluminimanagement.model.Person;
import com.miu.waa.aluminimanagement.model.dto.PersonDto;

import java.util.List;

public interface PersonService {
   PersonDto findById();

    PersonDto getById(int id);

    String sendPasswordResetEmail(int id, String recipient);

    void updateAddress(int id, Address address);

    void changeStatus(int id, Boolean status);

    List<Person> findAll();
}
