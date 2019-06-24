package com.sxd.server.mytime.controller.usercontroller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class FollowControllerTest {
    @Autowired
    private FollowController followController;

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
}