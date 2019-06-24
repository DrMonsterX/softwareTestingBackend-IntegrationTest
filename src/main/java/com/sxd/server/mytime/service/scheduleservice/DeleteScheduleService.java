package com.sxd.server.mytime.service.scheduleservice;

import com.sxd.server.mytime.dao.ScheduleMapper;
import org.springframework.stereotype.Service;

@Service
public class DeleteScheduleService {
    private final ScheduleMapper scheduleMapper;

    public DeleteScheduleService(ScheduleMapper scheduleMapper) {
        this.scheduleMapper = scheduleMapper;
    }

    public int deleteSchedule(Integer scheduleId) {
        return scheduleMapper.deleteByPrimaryKey(scheduleId);
    }
}
