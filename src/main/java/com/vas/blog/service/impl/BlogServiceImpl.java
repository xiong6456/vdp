package com.vas.blog.service.impl;

import com.vas.blog.mapper.BlogMainAuthMapper;
import com.vas.blog.mapper.BlogMainCateMapper;
import com.vas.blog.mapper.BlogMainMapper;
import com.vas.blog.pojo.BlogMain;
import com.vas.blog.service.BlogService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hevin*Xiong
 * @version 1.0.0
 * @Description 用户管理
 * @time 2018-2-2 下午11:55:01
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMainAuthMapper blogMainAuthMapper;

    @Autowired
    private BlogMainCateMapper blogMainCateMapper;

    @Autowired
    private BlogMainMapper blogMainMapper;

    @Override
    public JSONObject insert(BlogMain pBlog) throws Exception {
        JSONObject jsonObject = new JSONObject();
        blogMainMapper.insert(pBlog);
        return null;
    }

    @Override
    public String selectBox(BlogMain pBlog) throws Exception {
        return null;
    }

    @Override
    public String selectByUserId(String pageNum, String pageSize) throws Exception {
        return null;
    }
}
