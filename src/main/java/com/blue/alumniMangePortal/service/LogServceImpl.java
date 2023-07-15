package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.CLog;
import com.blue.alumniMangePortal.repository.LogRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LogServceImpl implements LogServce {
    private final LogRepo logRepo;
    @Override
    public CLog saveLog(CLog log){
        return logRepo.save(log);
    }
    @Override
    public List<String> getByMessage(String msg, Date date){
        return logRepo.findByMessageAndDatetime(msg, date);
    }
    @Override
    public List<CLog> getByDatatime(Date datetime1, Date datetime2){
        return logRepo.findByDatetimeBetween(datetime1, datetime2);
    }
}
