package com.example.demo.repository;

import com.example.demo.pojo.SysLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysLogRepository extends JpaRepository<SysLog, Long> {
}
