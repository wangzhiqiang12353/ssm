/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AdressController
 * Author:   PC
 * Date:     2020-09-15 16:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.controller;

import com.ytc.model.Adress;
import com.ytc.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author PC
 * @create 2020-09-15
 * @since 1.0.0
 */
@Controller
@RequestMapping("/adress")
public class AdressController {

    @Autowired
    private AdressService adressService;

    @RequestMapping("queryAdressList")
    @ResponseBody
    public List<Adress> queryAdressList(){
        List<Adress> list = adressService.queryAdressList();

        return list;

    }

}