package com.sxd.server.mytime.service.taskservice;

import com.sxd.server.mytime.dao.TaskMapper;
import com.sxd.server.mytime.entity.Task;
import org.springframework.stereotype.Service;

@Service
public class ModifyTaskService {
    private final TaskMapper taskMapper;

    public ModifyTaskService(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public int modifyTask(Task task) {
        return taskMapper.updateByPrimaryKey(task);
    }
}
