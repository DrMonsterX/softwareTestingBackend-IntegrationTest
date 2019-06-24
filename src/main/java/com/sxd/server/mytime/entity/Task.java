package com.sxd.server.mytime.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "task_id")
    private Integer taskId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "finish_time")
    private String finishTime;

    @Column(name = "is_complete")
    private Integer isComplete;

    @Column(name = "remark")
    private String remark;

    @Column(name = "is_remind")
    private Integer remind;

    @Column(name = "tag")
    private String tag;

    @Column(name = "position")
    private Integer position;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public void setIsComplete(Integer isComplete) {
        this.isComplete = isComplete;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setRemind(Integer remind) {
        this.remind = remind;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
