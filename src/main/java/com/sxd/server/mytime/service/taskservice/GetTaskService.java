package com.sxd.server.mytime.service.taskservice;

import com.sxd.server.mytime.dao.TaskMapper;
import com.sxd.server.mytime.entity.Task;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class GetTaskService {
    private final TaskMapper taskMapper;

    public GetTaskService(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    //获取对应userid的所有task
    public List<Task> getAllTask(Integer userId) {
        Example example = new Example(Task.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId);
        return taskMapper.selectByExample(example);
    }

    //获取对应userId，对应tag的所有task
    public List<Task> getTaskByTag(Integer userId, String tag) {
        Example example = new Example(Task.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId);
        criteria.andEqualTo("tag", tag);
        return taskMapper.selectByExample(example);
    }

    //获取对应taskId的task
    public Task getTaskById(Integer taskId) {
        return taskMapper.selectByPrimaryKey(taskId);
    }
}
