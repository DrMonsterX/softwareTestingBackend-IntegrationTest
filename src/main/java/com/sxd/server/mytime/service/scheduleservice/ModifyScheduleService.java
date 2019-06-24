package com.sxd.server.mytime.service.scheduleservice;

import com.sxd.server.mytime.dao.ScheduleMapper;
import com.sxd.server.mytime.entity.Schedule;
import org.springframework.stereotype.Service;

@Service
public class ModifyScheduleService {
    private final ScheduleMapper scheduleMapper;

    public ModifyScheduleService(ScheduleMapper scheduleMapper) {
        this.scheduleMapper = scheduleMapper;
    }

    public int modifySchedule(Schedule schedule) {
        return scheduleMapper.updateByPrimaryKey(schedule);
    }
}
