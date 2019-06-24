package com.sxd.server.mytime.controller.taskcontroller;

import com.sxd.server.mytime.entity.Task;
import com.sxd.server.mytime.service.taskservice.GetTaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetTaskController {
    private final GetTaskService getTaskService;

    public GetTaskController(GetTaskService getTaskService) {
        this.getTaskService = getTaskService;
    }

    //获取对应userId的所有task
    @RequestMapping(value = "getAllTask", method = RequestMethod.GET)
    public List<Task> getAllTask(Integer userId) {
        return getTaskService.getAllTask(userId);
    }

    //获取对应userId，对应tag的所有task
    @RequestMapping(value = "getTaskByTag", method = RequestMethod.GET)
    public List<Task> getTestByTag(Integer userId, String tag) {
        return getTaskService.getTaskByTag(userId, tag);
    }

    //获取对应taskId的task
    @RequestMapping(value = "getTaskById", method = RequestMethod.GET)
    public Task getTaskById(Integer taskId) {
        return getTaskService.getTaskById(taskId);
    }
}
