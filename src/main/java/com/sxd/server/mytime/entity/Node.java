package com.sxd.server.mytime.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "node")
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "node_id")
    private Integer nodeId;

    @Column(name = "task_id")
    private Integer taskId;

    @Column(name = "node_name")
    private String nodeName;

    @Column(name = "node_time")
    private String nodeTime;

    @Column(name = "is_complete")
    private Integer isComplete;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public void setNodeTime(String nodeTime) {
        this.nodeTime = nodeTime;
    }

    public void setIsComplete(Integer isComplete) {
        this.isComplete = isComplete;
    }
}
