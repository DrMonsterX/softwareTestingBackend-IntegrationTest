package com.sxd.server.mytime.service.completenessservice;

import com.sxd.server.mytime.dao.CompletenessMapper;
import com.sxd.server.mytime.entity.Completeness;
import org.springframework.stereotype.Service;

@Service
public class ModifyCompleteService {
    private final CompletenessMapper completenessMapper;

    public ModifyCompleteService(CompletenessMapper completenessMapper) {
        this.completenessMapper = completenessMapper;
    }

    public int updateCompleteness(Completeness completeness) {
        return completenessMapper.updateByPrimaryKey(completeness);
    }
}
