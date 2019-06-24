package com.sxd.server.mytime.controller.schedulecontroller;

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
public class GetScheduleControllerTest {
    @Autowired
    private GetScheduleController getScheduleController;

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
}