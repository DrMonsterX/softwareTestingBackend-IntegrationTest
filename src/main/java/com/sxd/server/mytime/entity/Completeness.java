package com.sxd.server.mytime.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "completeness")
public class Completeness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "completeness_id")
    private Integer completenessId;

    @Column(name = "week_completeness")
    private Integer weekCompleteness = 0;

    @Column(name = "history_one")
    private Integer historyOne = 0;

    @Column(name = "history_two")
    private Integer historyTwo = 0;

    @Column(name = "history_three")
    private Integer historyThree = 0;

    @Column(name = "history_four")
    private Integer historyFour = 0;

    @Column(name = "history_five")
    private Integer historyFive = 0;

    public Integer getCompletenessId() {
        return completenessId;
    }


    public Integer getWeekCompleteness() {
        return weekCompleteness;
    }

    public void setWeekCompleteness(Integer weekCompleteness) {
        this.weekCompleteness = weekCompleteness;
    }

    public Integer getHistoryOne() {
        return historyOne;
    }


    public Integer getHistoryTwo() {
        return historyTwo;
    }


    public Integer getHistoryThree() {
        return historyThree;
    }


    public Integer getHistoryFour() {
        return historyFour;
    }


    public Integer getHistoryFive() {
        return historyFive;
    }

}
