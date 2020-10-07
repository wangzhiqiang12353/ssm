/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: UserService
 * Author:   PC
 * Date:     2020-09-19 21:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.service;

import com.ytc.model.User;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author PC
 * @create 2020-09-19
 * @since 1.0.0
 */

public interface UserService {
    User queryUserByName(User user);


    void register(User user);
}

