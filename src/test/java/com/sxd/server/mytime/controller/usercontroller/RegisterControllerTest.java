package com.sxd.server.mytime.controller.usercontroller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class RegisterControllerTest {
    @Autowired
    private RegisterController registerController;

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
}