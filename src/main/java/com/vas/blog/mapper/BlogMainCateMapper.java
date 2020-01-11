package com.vas.blog.mapper;

import com.vas.blog.pojo.BlogMainCate;
import java.util.List;

public interface BlogMainCateMapper {
    int deleteByPrimaryKey(String fdId);

    int insert(BlogMainCate record);

    BlogMainCate selectByPrimaryKey(String fdId);

    List<BlogMainCate> selectAll();

    int updateByPrimaryKey(BlogMainCate record);
}