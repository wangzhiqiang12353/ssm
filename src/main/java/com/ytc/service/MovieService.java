/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MovieService
 * Author:   PC
 * Date:     2020-09-14 19:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.service;

import com.ytc.model.Movie;
import com.ytc.model.MovieDto;
import com.ytc.util.PageUtil;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author PC
 * @create 2020-09-14
 * @since 1.0.0
 */

public interface MovieService {

    PageUtil<Movie> queryMovieList(PageUtil<Movie> page, MovieDto movieDto);

    void addMovie(Movie movie);

    Movie queryMovieById(Integer movieid);

    void updateMovie(Movie movie);

    void deleteMovie(Integer movieid);

    void delsMovie(String ids);
}
