package com.rabin.springHibernate.repository;

import com.rabin.springHibernate.dto.CourseDTO;
import com.rabin.springHibernate.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
