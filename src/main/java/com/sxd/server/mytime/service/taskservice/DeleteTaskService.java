package com.sxd.server.mytime.service.taskservice;

import com.sxd.server.mytime.dao.TaskMapper;
import org.springframework.stereotype.Service;

@Service
public class DeleteTaskService {
    private final TaskMapper taskMapper;

    public DeleteTaskService(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public int deleteTask(Integer taskId) {
        return taskMapper.deleteByPrimaryKey(taskId);
    }
}
