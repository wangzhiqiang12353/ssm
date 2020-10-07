/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: YearController
 * Author:   PC
 * Date:     2020-09-15 16:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.controller;

import com.ytc.model.MovieYear;
import com.ytc.service.YearService;
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
@RequestMapping("/year")
public class YearController {
    @Autowired
    private YearService yearService;

    /**
     * 查询年代列表 返回json
     * @return
     */
    @RequestMapping("queryYearList")
    @ResponseBody
    public List<MovieYear> queryYearList(){

        List<MovieYear> list =yearService.queryYearList();

        return list;
    }
}