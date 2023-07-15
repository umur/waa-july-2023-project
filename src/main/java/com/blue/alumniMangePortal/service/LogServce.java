package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.CLog;

import java.util.Date;
import java.util.List;

public interface LogServce {
    CLog saveLog(CLog log);

    List<String> getByMessage(String msg, Date date);

    List<CLog> getByDatatime(Date datetime1, Date datetime2);
}
