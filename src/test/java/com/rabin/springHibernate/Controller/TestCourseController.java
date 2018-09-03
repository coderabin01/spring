package com.rabin.springHibernate.Controller;

import com.rabin.springHibernate.controller.CourseController;
import com.rabin.springHibernate.model.Course;
import com.rabin.springHibernate.service.CourseService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import org.apache.log4j.Logger;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(MockitoJUnitRunner.class)
public class TestCourseController {

    private static final Logger logger = Logger.getLogger(TestCourseController.class);

    private MockMvc mockMvc;

    Course course;

    @Mock
    CourseService courseService;

    @InjectMocks
    CourseController courseController;

    List<Course> courseList;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();
        course = new Course(600851475143L, "Science");
        courseList = Arrays.asList(new Course(600851475143L, "Science"));
    }

    @Test
    public void Should_Return_List_Of_Course() throws Exception{
        logger.info("Should_Return_List_Of_Course(): START");
        when(courseService.getCourseList()).thenReturn(courseList);
        MvcResult result = mockMvc.perform(get("/course")).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertNotNull(response.getContentAsString());
    }

}
