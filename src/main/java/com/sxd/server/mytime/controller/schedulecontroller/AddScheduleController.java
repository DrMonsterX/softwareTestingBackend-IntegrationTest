package com.sxd.server.mytime.controller.schedulecontroller;

import com.sxd.server.mytime.entity.Schedule;
import com.sxd.server.mytime.service.scheduleservice.AddScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddScheduleController {
    private final AddScheduleService addScheduleService;
    private static final int MESSING_INFORMATION = -1;

    public AddScheduleController(AddScheduleService addScheduleService) {
        this.addScheduleService = addScheduleService;
    }

    //添加日程
    @RequestMapping(value = "addSchedule", method = RequestMethod.GET)
    public int addSchedule(Integer userId, Integer position, String scheduleName, String startTime, String stopTime, String remark, Integer remind) {
        Schedule schedule = new Schedule();
        if (userId == null) {
            return MESSING_INFORMATION;
        }
        schedule.setUserId(userId);
        if (position == null) {
            return MESSING_INFORMATION;
        }
        schedule.setPosition(position);
        if (scheduleName == null) {
            return MESSING_INFORMATION;
        }
        schedule.setScheduleName(scheduleName);
        if (startTime == null) {
            return MESSING_INFORMATION;
        }
        schedule.setStartTime(startTime);
        if (stopTime == null) {
            return MESSING_INFORMATION;
        }
        schedule.setFinishTime(stopTime);
        schedule.setRemark(remark);
        if (remind == null) {
            return MESSING_INFORMATION;
        }
        schedule.setIsRemind(remind);
        return addScheduleService.addSchedule(schedule);
    }
}
