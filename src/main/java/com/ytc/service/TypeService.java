/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TypeService
 * Author:   PC
 * Date:     2020-09-15 15:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.service;

import com.ytc.model.MovieType;
import com.ytc.util.PageUtil;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author PC
 * @create 2020-09-15
 * @since 1.0.0
 */
public interface TypeService {
    List<MovieType> queryTypeList();

    PageUtil<MovieType> queryTypeLists(PageUtil<MovieType> page, MovieType movieType);
}
