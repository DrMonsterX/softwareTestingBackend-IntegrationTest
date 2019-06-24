package com.sxd.server.mytime.controller.schedulecontroller;

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
public class ModifyScheduleControllerTest {
    @Autowired
    private ModifyScheduleController modifyScheduleController;

    @Test
    public void modifyScheduleTest0() {
        assertThat(modifyScheduleController.modifySchedule(100,"test","123",
                "321","",1),is(-2));
    }

    @Test
    public void modifyScheduleTest1() {
        assertThat(modifyScheduleController.modifySchedule(null,"test","123",
                "321","",1),is(-2));
    }

    @Test
    public void modifyScheduleTest2() {
        assertThat(modifyScheduleController.modifySchedule(5,"test","123",
                "321","",1),is(1));
    }

    @Test
    public void modifyScheduleTest3() {
        assertThat(modifyScheduleController.modifySchedule(5,null,"123",
                "321","",1),is(-1));
    }

    @Test
    public void modifyScheduleTest4() {
        assertThat(modifyScheduleController.modifySchedule(5,"test",null,
                "321","",1),is(-1));
    }

    @Test
    public void modifyScheduleTest5() {
        assertThat(modifyScheduleController.modifySchedule(5,"test","123",
                null,"",1),is(-1));
    }

    @Test
    public void modifyScheduleTest6() {
        assertThat(modifyScheduleController.modifySchedule(5,"test","123",
                "321","",null),is(-1));
    }
}