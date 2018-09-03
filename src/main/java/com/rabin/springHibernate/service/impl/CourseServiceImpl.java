package com.rabin.springHibernate.service.impl;

import com.rabin.springHibernate.dto.CourseDTO;
import com.rabin.springHibernate.model.Course;
import com.rabin.springHibernate.repository.CourseRepository;
import com.rabin.springHibernate.service.CourseService;
import com.sun.istack.internal.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{
    private  static Logger logger = Logger.getLogger(CourseServiceImpl.class);

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> getCourseList(){
      logger.info("getCourseList(): START");
      return courseRepository.findAll();
    }
}
