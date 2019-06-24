package com.sxd.server.mytime.controller.schedulecontroller;

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
public class AddScheduleControllerTest {
    @Autowired
    private AddScheduleController addScheduleController;

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
}