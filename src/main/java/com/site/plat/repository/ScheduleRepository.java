package com.site.plat.repository;

import com.site.plat.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByTeacher(String teacher);
    List<Schedule> findByGroupName(String groupName);
}