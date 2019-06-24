package com.sxd.server.mytime.controller.usercontroller;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
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
public class RegisterControllerTest {
    @Autowired
    private RegisterController registerController;
    @Autowired
    private WebApplicationContext userController;
    private MockMvc mockmvc;

    @Before
    public void setUp() {
        mockmvc= MockMvcBuilders.webAppContextSetup(userController).build();
    }

    @Test
    public void registerTest0() {
        assertThat(registerController.register("Test4",1,"123"),greaterThan(0));
    }

    @Test
    public void registerTest1() {
        assertThat(registerController.register(null,1,"123"),is(-1));
    }

    @Test
    public void registerTest2() {
        assertThat(registerController.register("Test4",null,"123"),is(-1));
    }

    @Test
    public void registerTest3() {
        assertThat(registerController.register("Test4",1,null),is(-1));
    }

    @Test
    public void registerTestI0() {
        MockHttpServletRequestBuilder request;
        request = get("/register");
        request.param("name","Test4");
        request.param("iconId","1");
        request.param("password","123");
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
        assertThat(resultWord,not(nullValue()));
        assertThat(Integer.parseInt(resultWord),greaterThan(0));
    }

    @Test
    public void registerTestI1() {
        MockHttpServletRequestBuilder request;
        request = get("/register");
        request.param("iconId","1");
        request.param("password","123");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string(not("")))
                    .andExpect(content().string("-1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void registerTestI2() {
        MockHttpServletRequestBuilder request;
        request = get("/register");
        request.param("name","Test4");
        request.param("password","123");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string(not("")))
                    .andExpect(content().string("-1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void registerTestI3() {
        MockHttpServletRequestBuilder request;
        request = get("/register");
        request.param("name","Test4");
        request.param("iconId","1");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string(not("")))
                    .andExpect(content().string("-1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}