package com.site.plat.repository;

import com.site.plat.model.Grade;
import com.site.plat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByUserAndAcademicYear(User user, String academicYear);
    List<Grade> findByUser(User user);
}