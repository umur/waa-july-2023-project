package com.example.geeks.repos;

import com.example.geeks.entity.Log;
import com.example.geeks.entity.User;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LogRepo extends ListCrudRepository<Log, List<Log>> {

    public List<Log> getLogsByDateAndTimeIs(LocalDateTime dt);

    public List<Log> getLogsByUserIs(User u);

    public List<Log> getLogsByUserIsAndDateAndTimeIs(User u, LocalDateTime dt);


}
