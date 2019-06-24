package com.sxd.server.mytime.controller.completecontroller;

import com.sxd.server.mytime.entity.Completeness;
import com.sxd.server.mytime.service.completenessservice.GetCompleteService;
import com.sxd.server.mytime.service.completenessservice.ModifyCompleteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateCompleteController {
    private final GetCompleteService getCompleteService;
    private final ModifyCompleteService modifyCompleteService;
    private static final int COMPELTE_NOT_FOUND = -2;

    public UpdateCompleteController(GetCompleteService getCompleteService, ModifyCompleteService modifyCompleteService) {
        this.getCompleteService = getCompleteService;
        this.modifyCompleteService = modifyCompleteService;
    }

    //更新本周实时完成度
    @RequestMapping(value = "updateComplete", method = RequestMethod.GET)
    public int updateComplete(Integer userId, Integer weekCompleteness) {
        Completeness completeness = getCompleteService.getCompleteness(userId);
        if (completeness == null) {
            return COMPELTE_NOT_FOUND;
        }
        completeness.setWeekCompleteness(weekCompleteness);
        return modifyCompleteService.updateCompleteness(completeness);
    }
}
