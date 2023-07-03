package com.example.geeks.repos;

import com.example.geeks.entity.Application;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ApplicationRepo extends ListCrudRepository<Application, List<Application>> {

    public List<Application> getApplicationsByStudent_Id(Long StudentId);
    public Application getApplicationByAppIdIs(Long id);
}
