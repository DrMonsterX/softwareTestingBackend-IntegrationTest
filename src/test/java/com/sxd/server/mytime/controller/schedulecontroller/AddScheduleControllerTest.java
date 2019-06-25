package com.sxd.server.mytime.controller.schedulecontroller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AddScheduleControllerTest {
    @Autowired
    private AddScheduleController addScheduleController;

    @Autowired
    private WebApplicationContext scheduleController;
    private MockMvc mockmvc;

    @Before
    public void setUp() {
        mockmvc= MockMvcBuilders.webAppContextSetup(scheduleController).build();
    }

    @Test
    public void addScheduleTest0() {
        assertThat(addScheduleController.addSchedule(10,1,"Test2","123",
                "321","111",1),greaterThan(0));
    }

    @Test
    public void addScheduleTest1() {
        assertThat(addScheduleController.addSchedule(null,1,"Test2","123",
                "321","111",1),is(-1));
    }

    @Test
    public void addScheduleTest2() {
        assertThat(addScheduleController.addSchedule(10,null,"Test2","123",
                "321","111",1),is(-1));
    }

    @Test
    public void addScheduleTest3() {
        assertThat(addScheduleController.addSchedule(10,1,null,"123",
                "321","111",1),is(-1));
    }

    @Test
    public void addScheduleTest4() {
        assertThat(addScheduleController.addSchedule(10,1,"Test2",null,
                "321","111",1),is(-1));
    }

    @Test
    public void addScheduleTest5() {
        assertThat(addScheduleController.addSchedule(10,1,"Test2","123",
                null,"111",1),is(-1));
    }

    @Test
    public void addScheduleTest6() {
        assertThat(addScheduleController.addSchedule(10,1,"Test2","123",
                "321","111",null),is(-1));
    }

    @Test
    public void addScheduleTestI0() {
        MockHttpServletRequestBuilder request;
        request = get("/addSchedule");
        request.param("userId","10");
        request.param("position","1");
        request.param("scheduleName","Test2");
        request.param("startTime","123");
        request.param("stopTime","321");
        request.param("remark","111");
        request.param("remind","1");
        MvcResult result;
        String resultWord = null;
        try {
            result = mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string(not("")))
                    .andReturn();
            resultWord = result.getResponse().getContentAsString();
        }catch (Exception e){
            e.printStackTrace();
        }
        assertThat(resultWord,notNullValue());
        assertThat(Integer.parseInt(resultWord),greaterThan(0));
    }

    @Test
    public void addScheduleTestI1() {
        MockHttpServletRequestBuilder request;
        request = get("/addSchedule");
        request.param("position","1");
        request.param("scheduleName","Test2");
        request.param("startTime","123");
        request.param("stopTime","321");
        request.param("remark","111");
        request.param("remind","1");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void addScheduleTestI2() {
        MockHttpServletRequestBuilder request;
        request = get("/addSchedule");
        request.param("userId","10");
        request.param("scheduleName","Test2");
        request.param("startTime","123");
        request.param("stopTime","321");
        request.param("remark","111");
        request.param("remind","1");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void addScheduleTestI3() {
        MockHttpServletRequestBuilder request;
        request = get("/addSchedule");
        request.param("userId","10");
        request.param("position","1");
        request.param("startTime","123");
        request.param("stopTime","321");
        request.param("remark","111");
        request.param("remind","1");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void addScheduleTestI4() {
        MockHttpServletRequestBuilder request;
        request = get("/addSchedule");
        request.param("userId","10");
        request.param("position","1");
        request.param("scheduleName","Test2");
        request.param("stopTime","321");
        request.param("remark","111");
        request.param("remind","1");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void addScheduleTestI5() {
        MockHttpServletRequestBuilder request;
        request = get("/addSchedule");
        request.param("userId","10");
        request.param("position","1");
        request.param("scheduleName","Test2");
        request.param("startTime","123");
        request.param("remark","111");
        request.param("remind","1");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void addScheduleTestI6() {
        MockHttpServletRequestBuilder request;
        request = get("/addSchedule");
        request.param("userId","10");
        request.param("position","1");
        request.param("scheduleName","Test2");
        request.param("startTime","123");
        request.param("stopTime","321");
        request.param("remark","111");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}