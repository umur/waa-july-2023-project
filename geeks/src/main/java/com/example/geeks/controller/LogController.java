package com.example.geeks.controller;

import com.example.geeks.entity.Log;
import com.example.geeks.aspect.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    @Qualifier("los")
    @Autowired
    LogService logService;

    /*
    @PostMapping
    public Log addLog(@RequestBody Log log) {
        Log savedLog = logService.addLog(log);
        return savedLog;
    }
    */


    @GetMapping("/datetime/{datetime}")
    public List<Log> getLogsByDateAndTime(@PathVariable LocalDateTime datetime) {
        List<Log> logs = logService.getLogsByDateAndTime(datetime);
        return logs;
    }

    @GetMapping("/user/{userId}")
    public List<Log> getLogsByUser(@PathVariable Long userId) {
        // Assuming "userId" refers to the user's ID
        List<Log> logs = logService.getLogsByUser(userId);
        return logs;
    }

    @GetMapping("/user/{userId}/datetime/{datetime}")
    public List<Log> getLogsByUserAndDateAndTime(@PathVariable Long userId, @PathVariable LocalDateTime datetime) {
        // Assuming "userId" refers to the user's ID
        List<Log> logs = logService.getLogsByUserAndDateAndTime(userId, datetime);
        return logs;
    }
}
