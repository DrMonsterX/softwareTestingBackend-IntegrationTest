package com.sxd.server.mytime.controller.usercontroller;

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
public class GetUserControllerTest {
    @Autowired
    private GetUserController getUserController;

    @Autowired
    private WebApplicationContext userController;
    private MockMvc mockmvc;

    @Before
    public void setUp() {
        mockmvc=MockMvcBuilders.webAppContextSetup(userController).build();
    }

    @Test
    public void getUserTest0() {
        assertThat(getUserController.getUser(-1),nullValue());
    }

    @Test
    public void getUserTest1() {
        assertThat(getUserController.getUser(10).getUserId(),is(10));
    }

    @Test
    public void getUserTest2() {
        assertThat(getUserController.getUser(null),nullValue());
    }

    @Test
    public void getUserTest3() {
        assertThat(getUserController.getUser(100),nullValue());
    }

    @Test
    public void getUserTestI0() {
        MockHttpServletRequestBuilder request;
        request = get("/checkLogin");
        request.param("userId","-1");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string(""));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getUserTestI1() {
        MockHttpServletRequestBuilder request;
        request = get("/checkLogin");
        request.param("userId","10");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string(not("")))
                    .andExpect(jsonPath("$.userId").value(10));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getUserTestI2() {
        MockHttpServletRequestBuilder request;
        request = get("/checkLogin");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string(""));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getUserTestI3() {
        MockHttpServletRequestBuilder request;
        request = get("/checkLogin");
        request.param("userId","100");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string(""));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}