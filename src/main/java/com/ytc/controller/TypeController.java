/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TypeController
 * Author:   PC
 * Date:     2020-09-15 15:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.controller;

import com.ytc.model.MovieType;
import com.ytc.service.TypeService;
import com.ytc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    /**
     * 查询类型 以 json字符串的形式返回
     * @return
     */
    @RequestMapping("queryTypeList")
    @ResponseBody
    public List<MovieType> queryTypeList(){

        List<MovieType> list =typeService.queryTypeList();

        return list;
    }

    /**
     * 跳转类型列表页面
     * @return
     */
    @RequestMapping("toQueryType")
    public String toQueryType(){
        return "type/showType";
    }

    /**
     * 查询类型
     * @return
     */
    @RequestMapping("queryTypeLists")
    public String  queryTypeLists(Model model, PageUtil<MovieType> page , MovieType movieType){
        page=typeService.queryTypeLists(page,movieType);
        model.addAttribute("page",page);
        return "type/typeList";

    }

}