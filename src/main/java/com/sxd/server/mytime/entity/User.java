package com.sxd.server.mytime.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String name;

    @Column(name = "icon_id")
    private Integer iconId;

    @Column(name = "user_password")
    private String password;

    @Column(name = "completeness_id")
    private Integer completenessId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIconId(Integer iconId) {
        this.iconId = iconId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCompletenessId() {
        return completenessId;
    }

    public void setCompletenessId(Integer completenessId) {
        this.completenessId = completenessId;
    }
}
