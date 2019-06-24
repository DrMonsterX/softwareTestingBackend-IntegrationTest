package com.sxd.server.mytime.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "follow")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "follow_id")
    private Integer followId;

    @Column(name = "following_id")
    private Integer followingId;

    @Column(name = "followed_id")
    private Integer followedId;



    public void setFollowingId(Integer followingId) {
        this.followingId = followingId;
    }

    public Integer getFollowedId() {
        return followedId;
    }

    public void setFollowedId(Integer followedId) {
        this.followedId = followedId;
    }
}
