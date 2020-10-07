package com.ytc.mapper;

import com.ytc.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    /**
     * 查询当前的用户名是否存在
     * @param user
     * @return
     */
    User queryUserByName(User user);

    /**
     * 注册用户
     * @param user
     */
    void register(@Param("user") User user);
}