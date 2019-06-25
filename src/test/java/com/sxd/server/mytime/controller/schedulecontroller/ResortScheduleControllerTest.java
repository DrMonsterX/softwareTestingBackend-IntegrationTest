package com.sxd.server.mytime.controller.schedulecontroller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ResortScheduleControllerTest {
    @Autowired ResortScheduleController resortScheduleController;
    @Autowired
    private WebApplicationContext scheduleController;
    private MockMvc mockmvc;

    @Before
    public void setUp() {
        mockmvc= MockMvcBuilders.webAppContextSetup(scheduleController).build();
    }

    @Test
    public void resortScheduleTest0() {
        assertThat(resortScheduleController.resortSchedule(100,1),is(-2));
    }

    @Test
    public void resortScheduleTest1() {
        assertThat(resortScheduleController.resortSchedule(null,1),is(-2));
    }

    @Test
    public void resortScheduleTest2() {
        assertThat(resortScheduleController.resortSchedule(5,1),is(1));
    }

    @Test
    public void resortScheduleTest3() {
        assertThat(resortScheduleController.resortSchedule(5,null),is(-1));
    }

    @Test
    public void resortScheduleTestI0() {
        MockHttpServletRequestBuilder request;
        request = get("/resortSchedule");
        request.param("scheduleId","100");
        request.param("position","1");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-2"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void resortScheduleTestI1() {
        MockHttpServletRequestBuilder request;
        request = get("/resortSchedule");
        request.param("position","1");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-2"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void resortScheduleTestI2() {
        MockHttpServletRequestBuilder request;
        request = get("/resortSchedule");
        request.param("scheduleId","5");
        request.param("position","1");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void resortScheduleTestI3() {
        MockHttpServletRequestBuilder request;
        request = get("/resortSchedule");
        request.param("scheduleId","5");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}