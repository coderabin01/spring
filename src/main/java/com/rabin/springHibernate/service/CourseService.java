package com.rabin.springHibernate.service;

import com.rabin.springHibernate.dto.CourseDTO;
import com.rabin.springHibernate.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> getCourseList();
}
