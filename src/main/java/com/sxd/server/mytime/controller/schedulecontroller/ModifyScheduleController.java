package com.sxd.server.mytime.controller.schedulecontroller;

import com.sxd.server.mytime.entity.Schedule;
import com.sxd.server.mytime.service.scheduleservice.GetScheduleService;
import com.sxd.server.mytime.service.scheduleservice.ModifyScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModifyScheduleController {
    private final ModifyScheduleService modifyScheduleService;
    private final GetScheduleService getScheduleService;
    private static final Integer SCHEDULE_NOT_FOUND = -2;
    private static final Integer MESSING_INFORMATION = -1;

    public ModifyScheduleController(ModifyScheduleService modifyScheduleService, GetScheduleService getScheduleService) {
        this.modifyScheduleService = modifyScheduleService;
        this.getScheduleService = getScheduleService;
    }

    //根据scheduleId获取schedule后修改其信息，返回结果状态码。
    @RequestMapping(value = "modifySchedule", method = RequestMethod.GET)
    public int modifySchedule(Integer scheduleId, String scheduleName, String startTime, String stopTime, String remark, Integer remind) {
        Schedule schedule = getScheduleService.getScheduleById(scheduleId);
        if (schedule == null) {
            return SCHEDULE_NOT_FOUND;
        }
        if (startTime == null) {
            return MESSING_INFORMATION;
        }
        schedule.setStartTime(startTime);
        if (scheduleName == null) {
            return MESSING_INFORMATION;
        }
        schedule.setScheduleName(scheduleName);
        if (stopTime == null) {
            return MESSING_INFORMATION;
        }
        schedule.setFinishTime(stopTime);
        schedule.setRemark(remark);
        if (remind == null) {
            return MESSING_INFORMATION;
        }
        schedule.setIsRemind(remind);
        return modifyScheduleService.modifySchedule(schedule);
    }
}
