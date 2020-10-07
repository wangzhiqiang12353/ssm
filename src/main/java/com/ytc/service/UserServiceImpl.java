/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: UserServiceImpl
 * Author:   PC
 * Date:     2020-09-20 12:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.service;

import com.ytc.mapper.MovieFileMapper;
import com.ytc.mapper.UserMapper;
import com.ytc.model.MovieFile;
import com.ytc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author PC
 * @create 2020-09-20
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MovieFileMapper movieFileMapper;



    public User queryUserByName(User user) {
        return userMapper.queryUserByName(user);
    }

    @Override
    public void register(User user) {
        MovieFile movieFile=new MovieFile();
        movieFile.setFilepath(user.getMovieFile().getFilepath());
        movieFileMapper.addMovieFile(movieFile);
        user.setMovieFile(movieFile);
        userMapper.register(user);

    }


}