package com.sxd.server.mytime.service.scheduleservice;

import com.sxd.server.mytime.dao.ScheduleMapper;
import com.sxd.server.mytime.entity.Schedule;
import org.springframework.stereotype.Service;

@Service
public class AddScheduleService {
    private final ScheduleMapper scheduleMapper;

    public AddScheduleService(ScheduleMapper scheduleMapper) {
        this.scheduleMapper = scheduleMapper;
    }

    public int addSchedule(Schedule schedule) {
        return scheduleMapper.insert(schedule);
    }
}
