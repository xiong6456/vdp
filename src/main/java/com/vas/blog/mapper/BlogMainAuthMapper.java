package com.vas.blog.mapper;

import com.vas.blog.pojo.BlogMainAuth;
import java.util.List;

public interface BlogMainAuthMapper {
    int insert(BlogMainAuth record);

    List<BlogMainAuth> selectAll();
}