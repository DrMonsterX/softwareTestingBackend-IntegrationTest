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
public class ResortScheduleControllerTest {
    @Autowired ResortScheduleController resortScheduleController;

    @Test
    public void resortScheduleTest0() {
        assertThat(resortScheduleController.resortSchedule(100,1),is(-2));
    }

    @Test
    public void resortScheduleTest1() {
        assertThat(resortScheduleController.resortSchedule(null,1),is(-2));
    }

    @Test
    public void resortScheduleTest2() {
        assertThat(resortScheduleController.resortSchedule(5,1),is(1));
    }

    @Test
    public void resortScheduleTest3() {
        assertThat(resortScheduleController.resortSchedule(5,null),is(-1));
    }
}