package com.sxd.server.mytime.controller.taskcontroller;

import com.sxd.server.mytime.entity.Task;
import com.sxd.server.mytime.service.taskservice.GetTaskService;
import com.sxd.server.mytime.service.taskservice.ModifyTaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResortTaskController {
    private final ModifyTaskService modifyTaskService;
    private final GetTaskService getTaskService;
    private static final int TASK_NOT_FOUND = -2;

    public ResortTaskController(ModifyTaskService modifyTaskService, GetTaskService getTaskService) {
        this.modifyTaskService = modifyTaskService;
        this.getTaskService = getTaskService;
    }

    //对任务进行重新排序
    @RequestMapping(value = "resortTask", method = RequestMethod.GET)
    public int resortTask(Integer taskId, Integer position) {
        Task task = getTaskService.getTaskById(taskId);
        if (task == null) {
            return TASK_NOT_FOUND;
        }
        task.setPosition(position);
        return modifyTaskService.modifyTask(task);
    }
}
