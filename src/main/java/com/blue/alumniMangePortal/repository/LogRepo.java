package com.blue.alumniMangePortal.repository;
import com.blue.alumniMangePortal.entity.CLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LogRepo extends JpaRepository<CLog,Long> {
   List<String> findByMessageAndDatetime(String message, Date datetime);
   List<CLog> findByDatetimeBetween(Date datetime1, Date datetime2);
}
