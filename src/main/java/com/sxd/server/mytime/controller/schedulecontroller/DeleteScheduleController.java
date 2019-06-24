package com.sxd.server.mytime.controller.schedulecontroller;


import com.sxd.server.mytime.service.scheduleservice.DeleteScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteScheduleController {
    private final DeleteScheduleService deleteScheduleService;

    public DeleteScheduleController(DeleteScheduleService deleteScheduleService) {
        this.deleteScheduleService = deleteScheduleService;
    }

    //根据scheduleId删除对应日程，返回结果状态码。
    @RequestMapping(value = "deleteSchedule", method = RequestMethod.GET)
    public int deleteSchedule(Integer scheduleId) {
        return deleteScheduleService.deleteSchedule(scheduleId);
    }
}
