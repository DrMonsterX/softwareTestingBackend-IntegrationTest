package com.sxd.server.mytime.controller.usercontroller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GetUserControllerTest {
    @Autowired
    private GetUserController getUserController;

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
}