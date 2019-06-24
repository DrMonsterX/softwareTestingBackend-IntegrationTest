package com.sxd.server.mytime.controller.taskcontroller;

import com.sxd.server.mytime.entity.Node;
import com.sxd.server.mytime.service.taskservice.NodeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NodeController {
    private final NodeService nodeService;

    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    //添加结点
    @RequestMapping(value = "addNode", method = RequestMethod.GET)
    public int addNode(Integer taskId, String nodeName, String nodeTime, Integer finishNum) {
        Node node = new Node();
        node.setTaskId(taskId);
        node.setNodeName(nodeName);
        node.setNodeTime(nodeTime);
        node.setIsComplete(finishNum);
        return nodeService.addNode(node);
    }

    //获取任务id对应的所有节点
    @RequestMapping(value = "getNodeByTaskId", method = RequestMethod.GET)
    public List<Node> getNodeByTaskId(Integer taskId) {
        return nodeService.getNodeByTaskId(taskId);
    }

    //删除对应任务所有结点
    @RequestMapping(value = "deleteAllNode", method = RequestMethod.GET)
    public int deleteAllNode(Integer taskId) {
        return nodeService.deleteAllNode(taskId);
    }

    //修改结点完成信息
    @RequestMapping(value = "finishNode", method = RequestMethod.GET)
    public int finishNode(Integer nodeId, Integer finishNum) {
        return nodeService.finishNode(nodeId, finishNum);
    }
}
