package com.sxd.server.mytime.controller.schedulecontroller;

import com.sxd.server.mytime.entity.Schedule;
import com.sxd.server.mytime.service.scheduleservice.GetScheduleService;
import com.sxd.server.mytime.service.scheduleservice.ModifyScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResortScheduleController {
    private final GetScheduleService getScheduleService;
    private final ModifyScheduleService modifyScheduleService;
    private static final int SCHEDULE_NOT_FOUND = -2;
    private static final int MESSING_INFORMATION = -1;

    public ResortScheduleController(GetScheduleService getScheduleService, ModifyScheduleService modifyScheduleService) {
        this.getScheduleService = getScheduleService;
        this.modifyScheduleService = modifyScheduleService;
    }

    //修改日程位置信息
    @RequestMapping(value = "resortSchedule", method = RequestMethod.GET)
    public int resortSchedule(Integer scheduleId, Integer position) {
        Schedule schedule = getScheduleService.getScheduleById(scheduleId);
        if (schedule == null) {
            return SCHEDULE_NOT_FOUND;
        }
        if (position == null) {
            return MESSING_INFORMATION;
        }
        schedule.setPosition(position);
        return modifyScheduleService.modifySchedule(schedule);
    }
}
