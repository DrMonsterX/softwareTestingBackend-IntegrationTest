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
public class DeleteScheduleControllerTest {
    @Autowired
    private DeleteScheduleController deleteScheduleController;

    @Test
    public void deleteScheduleTest0() {
        assertThat(deleteScheduleController.deleteSchedule(-1),is(0));
    }

    @Test
    public void deleteScheduleTest1() {
        assertThat(deleteScheduleController.deleteSchedule(5),is(1));
    }

    @Test
    public void deleteScheduleTest2() {
        assertThat(deleteScheduleController.deleteSchedule(100),is(0));
    }

    @Test
    public void deleteScheduleTest3() {
        assertThat(deleteScheduleController.deleteSchedule(null),is(0));
    }
}