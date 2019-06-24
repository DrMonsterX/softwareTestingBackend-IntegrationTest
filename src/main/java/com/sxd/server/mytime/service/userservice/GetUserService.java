package com.sxd.server.mytime.service.userservice;

import com.sxd.server.mytime.dao.UserMapper;
import com.sxd.server.mytime.entity.User;
import org.springframework.stereotype.Service;

@Service
public class GetUserService {
    private final UserMapper userMapper;

    public GetUserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //通过userId主键查询user信息
    public User getUser(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
