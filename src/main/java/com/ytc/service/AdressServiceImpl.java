/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AdressServiceImpl
 * Author:   PC
 * Date:     2020-09-15 16:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.service;

import com.ytc.mapper.AdressMapper;
import com.ytc.model.Adress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author PC
 * @create 2020-09-15
 * @since 1.0.0
 */
@Service
public class AdressServiceImpl  implements AdressService{
    @Autowired
    private AdressMapper adressMapper;

    public List<Adress> queryAdressList() {
        return adressMapper.queryAdressList();
    }
}