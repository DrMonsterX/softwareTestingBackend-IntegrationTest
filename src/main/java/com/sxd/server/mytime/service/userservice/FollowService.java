package com.sxd.server.mytime.service.userservice;

import com.sxd.server.mytime.dao.FollowMapper;
import com.sxd.server.mytime.entity.Follow;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class FollowService {
    private final FollowMapper followMapper;

    public FollowService(FollowMapper followMapper) {
        this.followMapper = followMapper;
    }

    //通过id获取关注列表
    public List<Follow> getFollow(Integer userId) {
        if (userId == null) {
            return new ArrayList<>();
        }
        Example example = new Example(Follow.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("followingId", userId);
        return followMapper.selectByExample(example);
    }

    //使当前用户关注目标用户
    public int followUser(Follow follow) {
        return followMapper.insert(follow);
    }

    //使当前用户取消关注目标用户
    public int deleteFollow(Integer myId, Integer targetId) {
        if (myId == null) {
            return 0;
        }
        if (targetId == null) {
            return 0;
        }
        Example example = new Example(Follow.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("followingId", myId);
        criteria.andEqualTo("followedId", targetId);
        return followMapper.deleteByExample(example);
    }
}
