package com.example.geeks.services;


import com.example.geeks.entity.Log;
import com.example.geeks.entity.User;
import com.example.geeks.repos.LogRepo;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class LogService {

    private final LogRepo loRepo;


    public Log addLog(Log l){
        return loRepo.save(l);
    }

    public List<Log> getLogsByDateAndTime(LocalDateTime dt){
        return loRepo.getLogsByTimeIs(dt);
    }

    public List<Log> getLogsByUser(User u){
        return loRepo.getLogsByUserIs(u);
    }

    public List<Log> getLogsByUserAndDateAndTime(User u, LocalDateTime dt){
        return loRepo.getLogsByUserIsAndTimeIs(u, dt);
    }
}
