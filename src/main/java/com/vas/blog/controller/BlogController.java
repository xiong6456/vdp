package com.vas.blog.controller;

import com.vas.blog.pojo.BlogMain;
import com.vas.blog.service.BlogService;
import com.vas.sys.organization.pojo.SysUser;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Hevin*Xiong
 * @version 1.0.0
 * @Description
 * @time 2018-2-3 上午9:03:29
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    private static final Logger logger = LoggerFactory
            .getLogger(BlogController.class);
    @Autowired
    private BlogService blogService;

    @ResponseBody
    @RequestMapping("/add")
    public String add(BlogMain pBlogMain) {
        JSONObject jsonObject = new JSONObject();
        try {
            JSONObject rtnObj = blogService.insert(pBlogMain);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

}
