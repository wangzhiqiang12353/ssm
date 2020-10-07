/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: UserController
 * Author:   PC
 * Date:     2020-09-19 19:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.controller;

import com.ytc.model.User;
import com.ytc.service.UserService;
import com.ytc.util.CheckImgUtil;
import com.ytc.util.FileUtil;
import com.ytc.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author PC
 * @create 2020-09-19
 * @since 1.0.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 生成验证码
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("imgCode")
    @ResponseBody
    public void imgCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CheckImgUtil.checkImg(request, response);

    }

    /**
     * 跳注册页面
     *
     * @return
     */
    @RequestMapping("toReg")
    public String toReg() {
        return "user/register";

    }


    /**
     * 查询用户名是否存在
     *
     * @param user
     * @return
     */
    @RequestMapping("queryUserByName")
    @ResponseBody
    public String queryUserByName(User user) {
        User userRet = userService.queryUserByName(user);
        if (userRet != null) {
            return "1";
        } else {
            return "2";
        }
    }

    /***
     * 上传头像
     * @param image
     * @param request
     * @return
     */
    @RequestMapping("uploadUserImg")
    @ResponseBody
    public String uploadUserImg(MultipartFile image, HttpServletRequest request) {
        return FileUtil.FileUpload(image, request);
    }


    /**
     * 注册
     *
     * @param user
     * @return
     */
    @RequestMapping("register")
    public String register(User user) {
        //密码加密
        String userpwd = user.getUserpwd();
        String md516 = Md5Util.getMd516(userpwd);
        user.setUserpwd(md516);
        userService.register(user);
        return "login";
    }

    /**
     * 登录方法
     *
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public String login(User user, String imgcode, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String checkcode = (String) session.getAttribute("checkcode");
        if (!imgcode.equals(checkcode)) {
            return "1";
        }
        User user1 = userService.queryUserByName(user);
        if (user1 != null) {
            String md516 = Md5Util.getMd516(user.getUserpwd());
            if (md516.equals(user1.getUserpwd())) {
                session.setAttribute("user", user1);
                return "4";
            } else {
                return "3";
            }
        } else {
            return "2";
        }
    }
}
