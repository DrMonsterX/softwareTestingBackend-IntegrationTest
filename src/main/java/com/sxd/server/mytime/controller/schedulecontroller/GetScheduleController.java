package com.sxd.server.mytime.controller.schedulecontroller;

import com.sxd.server.mytime.entity.Schedule;
import com.sxd.server.mytime.service.scheduleservice.GetScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetScheduleController {
    private final GetScheduleService getScheduleService;

    public GetScheduleController(GetScheduleService getScheduleService) {
        this.getScheduleService = getScheduleService;
    }

    //根据scheduleId获取该Schedule信息
    @RequestMapping(value = "getScheduleById", method = RequestMethod.GET)
    public Schedule getScheduleById(Integer scheduleId) {
        return getScheduleService.getScheduleById(scheduleId);
    }

    //获取目标用户的所有日程信息
    @RequestMapping(value = "getScheduleByUser", method = RequestMethod.GET)
    public List<Schedule> getScheduleByUser(Integer userId) {
        return getScheduleService.getScheduleByUser(userId);
    }
}
