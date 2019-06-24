package com.sxd.server.mytime.dao;

import com.sxd.server.mytime.entity.Task;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface TaskMapper extends Mapper<Task> {
}
