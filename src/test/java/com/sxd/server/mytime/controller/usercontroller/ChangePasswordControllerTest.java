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

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ChangePasswordControllerTest {
    @Autowired
    private ChangePasswordController changePasswordController;
    @Autowired
    private WebApplicationContext userController;
    private MockMvc mockmvc;

    @Before
    public void setUp() {
        mockmvc= MockMvcBuilders.webAppContextSetup(userController).build();
    }

    @Test
    public void changePasswordTest0() {
        assertThat(changePasswordController.changePassword(10,"123"),is(1));
    }

    @Test
    public void changePasswordTest1() {
        assertThat(changePasswordController.changePassword(100,"123"),is(-2));
    }

    @Test
    public void changePasswordTest2() {
        assertThat(changePasswordController.changePassword(10,null),is(-1));
    }

    @Test
    public void changePasswordTest3() {
        assertThat(changePasswordController.changePassword(100,null),is(-1));
    }

    @Test
    public void changePasswordTest4() {
        assertThat(changePasswordController.changePassword(-1,"123"),is(-2));
    }

    @Test
    public void changePasswordTest5() {
        assertThat(changePasswordController.changePassword(null,"123"),is(-2));
    }

    @Test
    public void changePasswordTestI0() {
        MockHttpServletRequestBuilder request;
        request = get("/changePassword");
        request.param("userId","10");
        request.param("password","123");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void changePasswordTestI1() {
        MockHttpServletRequestBuilder request;
        request = get("/changePassword");
        request.param("userId","100");
        request.param("password","123");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-2"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void changePasswordTestI2() {
        MockHttpServletRequestBuilder request;
        request = get("/changePassword");
        request.param("userId","10");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void changePasswordTestI3() {
        MockHttpServletRequestBuilder request;
        request = get("/changePassword");
        request.param("userId","100");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void changePasswordTestI4() {
        MockHttpServletRequestBuilder request;
        request = get("/changePassword");
        request.param("userId","-1");
        request.param("password","123");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-2"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void changePasswordTestI5() {
        MockHttpServletRequestBuilder request;
        request = get("/changePassword");
        request.param("password","123");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-2"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}