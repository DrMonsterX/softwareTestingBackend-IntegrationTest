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
public class FollowControllerTest {
    @Autowired
    private FollowController followController;
    @Autowired
    private WebApplicationContext userController;
    private MockMvc mockmvc;

    @Before
    public void setUp() {
        mockmvc= MockMvcBuilders.webAppContextSetup(userController).build();
    }

    @Test
    public void getFollowTest0() {
        assertThat(followController.getFollow(-1),is(empty()));
    }

    @Test
    public void getFollowTest1() {
        assertThat(followController.getFollow(10).size(),greaterThan(0));
        assertThat(followController.getFollow(10).get(0).getUserId(),is(11));
    }

    @Test
    public void getFollowTest2() {
        assertThat(followController.getFollow(100),is(empty()));
    }

    @Test
    public void getFollowTest3() {
        assertThat(followController.getFollow(null),is(empty()));
    }

    @Test
    public void followUserTest0() {
        assertThat(followController.followUser(100,10),is(-3));
    }

    @Test
    public void followUserTest1() {
        assertThat(followController.followUser(null,10),is(-3));
    }

    @Test
    public void followUserTest2() {
        assertThat(followController.followUser(10,100),is(-4));
    }

    @Test
    public void followUserTest3() {
        assertThat(followController.followUser(10,null),is(-4));
    }

    @Test
    public void followUserTest4() {
        assertThat(followController.followUser(10,12),is(1));
    }

    @Test
    public void followUserTest5() {
        assertThat(followController.followUser(10,10),is(-2));
    }

    @Test
    public void deleteFollowTest0() {
        assertThat(followController.deleteFollow(100,10),is(-3));
    }

    @Test
    public void deleteFollowTest1() {
        assertThat(followController.deleteFollow(null,10),is(-3));
    }

    @Test
    public void deleteFollowTest2() {
        assertThat(followController.deleteFollow(10,100),is(-4));
    }

    @Test
    public void deleteFollowTest3() {
        assertThat(followController.deleteFollow(10,null),is(-4));
    }

    @Test
    public void deleteFollowTest4() {
        assertThat(followController.deleteFollow(10,11),is(1));
    }

    @Test
    public void deleteFollowTest5() {
        assertThat(followController.deleteFollow(10,10),is(-2));
    }

    @Test
    public void getFollowTestI0() {
        MockHttpServletRequestBuilder request;
        request = get("/getFollow");
        request.param("userId","-1");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("[]"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getFollowTestI1() {
        MockHttpServletRequestBuilder request;
        request = get("/getFollow");
        request.param("userId","10");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string(not("[]")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getFollowTestI2() {
        MockHttpServletRequestBuilder request;
        request = get("/getFollow");
        request.param("userId","100");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("[]"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getFollowTestI3() {
        MockHttpServletRequestBuilder request;
        request = get("/getFollow");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("[]"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void followUserTestI0() {
        MockHttpServletRequestBuilder request;
        request = get("/followUser");
        request.param("myId","100");
        request.param("targetId","10");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-3"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void followUserTestI1() {
        MockHttpServletRequestBuilder request;
        request = get("/followUser");
        request.param("targetId","10");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-3"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void followUserTestI2() {
        MockHttpServletRequestBuilder request;
        request = get("/followUser");
        request.param("myId","10");
        request.param("targetId","100");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-4"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void followUserTestI3() {
        MockHttpServletRequestBuilder request;
        request = get("/followUser");
        request.param("myId","10");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-4"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void followUserTestI4() {
        MockHttpServletRequestBuilder request;
        request = get("/followUser");
        request.param("myId","10");
        request.param("targetId","12");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void followUserTestI5() {
        MockHttpServletRequestBuilder request;
        request = get("/followUser");
        request.param("myId","10");
        request.param("targetId","10");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-2"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteFollowTestI0() {
        MockHttpServletRequestBuilder request;
        request = get("/deleteFollow");
        request.param("myId","100");
        request.param("targetId","10");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-3"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteFollowTestI1() {
        MockHttpServletRequestBuilder request;
        request = get("/deleteFollow");
        request.param("targetId","10");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-3"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteFollowTestI2() {
        MockHttpServletRequestBuilder request;
        request = get("/deleteFollow");
        request.param("myId","10");
        request.param("targetId","100");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-4"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteFollowTestI3() {
        MockHttpServletRequestBuilder request;
        request = get("/deleteFollow");
        request.param("myId","10");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-4"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteFollowTestI4() {
        MockHttpServletRequestBuilder request;
        request = get("/deleteFollow");
        request.param("myId","10");
        request.param("targetId","11");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteFollowTestI5() {
        MockHttpServletRequestBuilder request;
        request = get("/deleteFollow");
        request.param("myId","10");
        request.param("targetId","10");
        try {
            mockmvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("-2"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}