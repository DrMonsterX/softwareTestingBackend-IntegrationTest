package com.sxd.server.mytime.dao;

import com.sxd.server.mytime.entity.Follow;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface FollowMapper extends Mapper<Follow> {
}
