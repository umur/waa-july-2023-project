package com.alumni.repository;

import com.alumni.entity.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseUserRepository extends JpaRepository<BaseUser,Long> {
}
