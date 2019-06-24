package com.sxd.server.mytime.service.taskservice;


import com.sxd.server.mytime.dao.TaskMapper;
import com.sxd.server.mytime.entity.Task;
import org.springframework.stereotype.Service;

@Service
public class AddTaskService {
    private final TaskMapper taskMapper;

    public AddTaskService(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public int addTask(Task task) {
        return taskMapper.insert(task);
    }

}
