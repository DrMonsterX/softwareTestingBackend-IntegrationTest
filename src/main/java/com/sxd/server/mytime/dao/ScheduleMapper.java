package com.sxd.server.mytime.dao;

import com.sxd.server.mytime.entity.Schedule;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ScheduleMapper extends Mapper<Schedule> {
}
