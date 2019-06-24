package com.sxd.server.mytime.controller.completecontroller;

import com.sxd.server.mytime.entity.Completeness;
import com.sxd.server.mytime.service.completenessservice.GetCompleteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class GetHistoryController {
    private final GetCompleteService getCompleteService;

    public GetHistoryController(GetCompleteService getCompleteService) {
        this.getCompleteService = getCompleteService;
    }

    //通过当前用户id获取该用户的历史5周完成度数组
    @RequestMapping(value = "getHistory", method = RequestMethod.GET)
    public List<Integer> getHistory(Integer userId) {
        List<Integer> list = new ArrayList<>();
        Completeness completeness = getCompleteService.getCompleteness(userId);
        if (completeness == null) {
            return list;
        }
        list.add(completeness.getHistoryOne());
        list.add(completeness.getHistoryTwo());
        list.add(completeness.getHistoryThree());
        list.add(completeness.getHistoryFour());
        list.add(completeness.getHistoryFive());
        return list;
    }
}
