package com.example.geeks.repos;

import com.example.geeks.entity.Log;
import com.example.geeks.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LogRepo extends JpaRepository<Log, List<Log>> {

    public List<Log> getLogsByTimeIs(LocalDateTime dt);

    public List<Log> getLogsByUser_IdIs(Long id);

    public List<Log> getLogsByUser_IdIsAndTimeIs(Long id, LocalDateTime dt);


}
