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
public class ModifyScheduleControllerTest {
    @Autowired
    private ModifyScheduleController modifyScheduleController;
    @Autowired
    private WebApplicationContext scheduleController;
    private MockMvc mockmvc;

    @Before
    public void setUp() {
        mockmvc= MockMvcBuilders.webAppContextSetup(scheduleController).build();
    }

    @Test
    public void modifyScheduleTest0() {
        assertThat(modifyScheduleController.modifySchedule(100,"test","123",
                "321","",1),is(-2));
    }

    @Test
    public void modifyScheduleTest1() {
        assertThat(modifyScheduleController.modifySchedule(null,"test","123",
                "321","",1),is(-2));
    }

    @Test
    public void modifyScheduleTest2() {
        assertThat(modifyScheduleController.modifySchedule(5,"test","123",
                "321","",1),is(1));
    }

    @Test
    public void modifyScheduleTest3() {
        assertThat(modifyScheduleController.modifySchedule(5,null,"123",
                "321","",1),is(-1));
    }

    @Test
    public void modifyScheduleTest4() {
        assertThat(modifyScheduleController.modifySchedule(5,"test",null,
                "321","",1),is(-1));
    }

    @Test
    public void modifyScheduleTest5() {
        assertThat(modifyScheduleController.modifySchedule(5,"test","123",
                null,"",1),is(-1));
    }

    @Test
    public void modifyScheduleTest6() {
        assertThat(modifyScheduleController.modifySchedule(5,"test","123",
                "321","",null),is(-1));
    }

    @Test
    public void modifyScheduleTestI0() {
        MockHttpServletRequestBuilder request;
        request = get("/modifySchedule");
        request.param("scheduleId","100");
        request.param("scheduleName","Test2");
        request.param("startTime","123");
        request.param("stopTime","321");
        request.param("remark","");
        request.param("remind","1");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-2"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void modifyScheduleTestI1() {
        MockHttpServletRequestBuilder request;
        request = get("/modifySchedule");
        request.param("scheduleName","Test2");
        request.param("startTime","123");
        request.param("stopTime","321");
        request.param("remark","");
        request.param("remind","1");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-2"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void modifyScheduleTestI2() {
        MockHttpServletRequestBuilder request;
        request = get("/modifySchedule");
        request.param("scheduleId","5");
        request.param("scheduleName","Test2");
        request.param("startTime","123");
        request.param("stopTime","321");
        request.param("remark","");
        request.param("remind","1");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void modifyScheduleTestI3() {
        MockHttpServletRequestBuilder request;
        request = get("/modifySchedule");
        request.param("scheduleId","5");
        request.param("startTime","123");
        request.param("stopTime","321");
        request.param("remark","");
        request.param("remind","1");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void modifyScheduleTestI4() {
        MockHttpServletRequestBuilder request;
        request = get("/modifySchedule");
        request.param("scheduleId","5");
        request.param("scheduleName","Test2");
        request.param("stopTime","321");
        request.param("remark","");
        request.param("remind","1");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void modifyScheduleTestI5() {
        MockHttpServletRequestBuilder request;
        request = get("/modifySchedule");
        request.param("scheduleId","5");
        request.param("scheduleName","Test2");
        request.param("startTime","123");
        request.param("remark","");
        request.param("remind","1");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void modifyScheduleTestI6() {
        MockHttpServletRequestBuilder request;
        request = get("/modifySchedule");
        request.param("scheduleId","5");
        request.param("scheduleName","Test2");
        request.param("startTime","123");
        request.param("stopTime","321");
        request.param("remark","");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}