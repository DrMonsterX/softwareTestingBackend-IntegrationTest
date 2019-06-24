package com.sxd.server.mytime.controller.taskcontroller;


import com.sxd.server.mytime.entity.Task;
import com.sxd.server.mytime.service.taskservice.AddTaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddTaskController {
    private final AddTaskService addTaskService;

    public AddTaskController(AddTaskService addTaskService) {
        this.addTaskService = addTaskService;
    }

    @RequestMapping(value = "addTask", method = RequestMethod.GET)
    public int addTask(Integer userId, Integer position, String taskName, String startTime, String stopTime,
                       String remark, Integer remind, String tag) {
        Task task = new Task();
        task.setUserId(userId);
        task.setTaskName(taskName);
        task.setTag(tag);
        task.setStartTime(startTime);
        task.setFinishTime(stopTime);
        task.setRemark(remark);
        task.setRemind(remind);
        task.setPosition(position);
        task.setIsComplete(0);
        return addTaskService.addTask(task);
    }
}
