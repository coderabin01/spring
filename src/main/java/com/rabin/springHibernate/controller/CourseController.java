package com.rabin.springHibernate.controller;

import com.rabin.springHibernate.dto.CourseDTO;
import com.rabin.springHibernate.model.Course;
import com.rabin.springHibernate.service.CourseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    public static Logger logger = Logger.getLogger(CourseController.class);

    @Autowired
    CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getCourseList(){
        logger.info("getCourseList(): START");
        List<Course> courseList = courseService.getCourseList();
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }

}
