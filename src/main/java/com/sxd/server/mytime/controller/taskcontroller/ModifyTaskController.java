package com.sxd.server.mytime.controller.taskcontroller;

import com.sxd.server.mytime.entity.Task;
import com.sxd.server.mytime.service.taskservice.GetTaskService;
import com.sxd.server.mytime.service.taskservice.ModifyTaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModifyTaskController {
    private final ModifyTaskService modifyTaskService;
    private final GetTaskService getTaskService;
    private static final Integer TASK_NOT_FOUND = -2;

    public ModifyTaskController(ModifyTaskService modifyTaskService, GetTaskService getTaskService) {
        this.modifyTaskService = modifyTaskService;
        this.getTaskService = getTaskService;
    }

    //修改任务,返回结果状态码
    @RequestMapping(value = "modifyTask", method = RequestMethod.GET)
    public int modifyTask(Integer taskId, String taskName, String startTime, String stopTime, Integer remind, String remark, String tag) {
        Task task = getTaskService.getTaskById(taskId);
        if (task == null) {
            return TASK_NOT_FOUND;
        }
        task.setTaskName(taskName);
        task.setStartTime(startTime);
        task.setFinishTime(stopTime);
        task.setRemind(remind);
        task.setRemark(remark);
        task.setTag(tag);
        return modifyTaskService.modifyTask(task);
    }
}
