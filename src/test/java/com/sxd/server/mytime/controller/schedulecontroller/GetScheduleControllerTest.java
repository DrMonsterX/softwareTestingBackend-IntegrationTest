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

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GetScheduleControllerTest {
    @Autowired
    private GetScheduleController getScheduleController;
    @Autowired
    private WebApplicationContext scheduleController;
    private MockMvc mockmvc;

    @Before
    public void setUp() {
        mockmvc= MockMvcBuilders.webAppContextSetup(scheduleController).build();
    }

    @Test
    public void getScheduleByIdTest0() {
        assertThat(getScheduleController.getScheduleById(-1),nullValue());
    }

    @Test
    public void getScheduleByIdTest1() {
        assertThat(getScheduleController.getScheduleById(5),notNullValue());
    }

    @Test
    public void getScheduleByIdTest2() {
        assertThat(getScheduleController.getScheduleById(100),nullValue());
    }

    @Test
    public void getScheduleByIdTest3() {
        assertThat(getScheduleController.getScheduleById(null),nullValue());
    }

    @Test
    public void getScheduleByUserTest0() {
        assertThat(getScheduleController.getScheduleByUser(-1),is(empty()));
    }

    @Test
    public void getScheduleByUserTest1() {
        assertThat(getScheduleController.getScheduleByUser(10),is(not(empty())));
        assertThat(getScheduleController.getScheduleByUser(10).size(),greaterThan(0));
    }

    @Test
    public void getScheduleByUserTest2() {
        assertThat(getScheduleController.getScheduleByUser(100),is(empty()));
    }

    @Test
    public void getScheduleByUserTest3() {
        assertThat(getScheduleController.getScheduleByUser(null),is(empty()));
    }

    @Test
    public void getScheduleByIdTestI0() {
        MockHttpServletRequestBuilder request;
        request = get("/getScheduleById");
        request.param("scheduleId","-1");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string(""));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getScheduleByIdTestI1() {
        MockHttpServletRequestBuilder request;
        request = get("/getScheduleById");
        request.param("scheduleId","5");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string(not("")))
                    .andExpect(content().string(notNullValue()))
                    .andExpect(content().string(not("{}")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getScheduleByIdTestI2() {
        MockHttpServletRequestBuilder request;
        request = get("/getScheduleById");
        request.param("scheduleId","100");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string(""));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getScheduleByIdTestI3() {
        MockHttpServletRequestBuilder request;
        request = get("/getScheduleById");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string(""));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getScheduleByUserTestI0() {
        MockHttpServletRequestBuilder request;
        request = get("/getScheduleByUser");
        request.param("userId","-1");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("[]"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getScheduleByUserTestI1() {
        MockHttpServletRequestBuilder request;
        request = get("/getScheduleByUser");
        request.param("userId","10");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string(not("")))
                    .andExpect(content().string(notNullValue()))
                    .andExpect(content().string(not("[]")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getScheduleByUserTestI2() {
        MockHttpServletRequestBuilder request;
        request = get("/getScheduleByUser");
        request.param("userId","100");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("[]"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getScheduleByUserTestI3() {
        MockHttpServletRequestBuilder request;
        request = get("/getScheduleByUser");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("[]"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}