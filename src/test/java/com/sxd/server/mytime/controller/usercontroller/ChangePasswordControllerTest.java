package com.sxd.server.mytime.controller.usercontroller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ChangePasswordControllerTest {
    @Autowired
    private ChangePasswordController changePasswordController;

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
        assertThat(changePasswordController.changePassword(100,null),is(-2));
    }

    @Test
    public void changePasswordTest4() {
        assertThat(changePasswordController.changePassword(-1,"123"),is(-2));
    }

    @Test
    public void changePasswordTest5() {
        assertThat(changePasswordController.changePassword(null,"123"),is(-2));
    }
}