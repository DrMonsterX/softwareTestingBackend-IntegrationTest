package com.sxd.server.mytime.dao;

import com.sxd.server.mytime.entity.Node;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface NodeMapper extends Mapper<Node> {
}
