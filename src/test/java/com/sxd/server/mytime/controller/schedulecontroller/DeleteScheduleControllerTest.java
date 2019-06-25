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
public class DeleteScheduleControllerTest {
    @Autowired
    private DeleteScheduleController deleteScheduleController;
    @Autowired
    private WebApplicationContext scheduleController;
    private MockMvc mockmvc;

    @Before
    public void setUp() {
        mockmvc= MockMvcBuilders.webAppContextSetup(scheduleController).build();
    }

    @Test
    public void deleteScheduleTest0() {
        assertThat(deleteScheduleController.deleteSchedule(-1),is(0));
    }

    @Test
    public void deleteScheduleTest1() {
        assertThat(deleteScheduleController.deleteSchedule(5),is(1));
    }

    @Test
    public void deleteScheduleTest2() {
        assertThat(deleteScheduleController.deleteSchedule(100),is(0));
    }

    @Test
    public void deleteScheduleTest3() {
        assertThat(deleteScheduleController.deleteSchedule(null),is(0));
    }

    @Test
    public void deleteScheduleTestI0() {
        MockHttpServletRequestBuilder request;
        request = get("/deleteSchedule");
        request.param("scheduleId","-1");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("0"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteScheduleTestI1() {
        MockHttpServletRequestBuilder request;
        request = get("/deleteSchedule");
        request.param("scheduleId","5");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteScheduleTestI2() {
        MockHttpServletRequestBuilder request;
        request = get("/deleteSchedule");
        request.param("scheduleId","100");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("0"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteScheduleTestI3() {
        MockHttpServletRequestBuilder request;
        request = get("/deleteSchedule");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("0"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}