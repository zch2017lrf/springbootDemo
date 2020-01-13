package com.p6.springjpa.repository;

import com.p6.springjpa.entity.area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface areaRepository extends JpaRepository<area, Long> {

}
