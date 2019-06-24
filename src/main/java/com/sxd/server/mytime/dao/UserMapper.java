package com.sxd.server.mytime.dao;

import com.sxd.server.mytime.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User> {
}
