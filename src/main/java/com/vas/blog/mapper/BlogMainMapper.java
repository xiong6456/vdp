package com.vas.blog.mapper;

import com.vas.blog.pojo.BlogMain;
import java.util.List;

public interface BlogMainMapper {
    int deleteByPrimaryKey(String fdId);

    int insert(BlogMain record);

    BlogMain selectByPrimaryKey(String fdId);

    List<BlogMain> selectAll();

    int updateByPrimaryKey(BlogMain record);
}