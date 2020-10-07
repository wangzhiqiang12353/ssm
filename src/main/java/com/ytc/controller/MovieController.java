/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MovieController
 * Author:   PC
 * Date:     2020-09-14 19:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.controller;

import com.ytc.model.*;
import com.ytc.service.AdressService;
import com.ytc.service.MovieService;
import com.ytc.service.TypeService;
import com.ytc.service.YearService;
import com.ytc.util.FileUtil;
import com.ytc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author PC
 * @create 2020-09-14
 * @since 1.0.0
 */

@Controller
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private AdressService adressService;
    @Autowired
    private YearService yearService;


    /**
     * 跳转查询电影页面
     * @return
     */
    @RequestMapping("toQueryMovie")
    public String toQueryMovie(){

        return "movie/showMovie";
    }

    /**
     * 查询电影列表
     * @return
     */
    @RequestMapping("queryMovieList")
    public String queryMovieList(Model model, PageUtil<Movie> page, MovieDto movieDto){
        page=movieService.queryMovieList(page,movieDto);
           model.addAttribute("page",page);

        return "movie/movieList";
    }

    /**
     * 跳转新增页面
     * @param model
     * @return
     */
    @RequestMapping("toAddMovie")
    public String toAddMovie(Model model){

        List<MovieType> movieTypes = typeService.queryTypeList();
        List<Adress> adresses = adressService.queryAdressList();
        List<MovieYear> movieYears = yearService.queryYearList();

        model.addAttribute("movieTypes",movieTypes);
        model.addAttribute("adresses",adresses);
        model.addAttribute("movieYears",movieYears);
        return"movie/addMovie";
    }

    /**
     * 上传文件
     * @return
     */
    @RequestMapping("uploadMovieImg")
    @ResponseBody
    public String uploadMovieImg(MultipartFile image, HttpServletRequest request){
        return FileUtil.FileUpload(image,request);
    }

    /**
     * 新增电影
     */
    @RequestMapping("addMovie")
    @ResponseBody
    public  void addMovie(Movie movie){
        movieService.addMovie(movie);
    }

    /**
     * 修改电影1 查询数据展示到页面
     * @return
     */
    @RequestMapping("toUpdateMovie")
     public String toUpdateMovie(Integer movieid,Model model){

        Movie movie= movieService.queryMovieById(movieid);
        model.addAttribute("movie",movie);

        List<MovieType> movieTypes = typeService.queryTypeList();
        List<Adress> adresses = adressService.queryAdressList();
        List<MovieYear> movieYears = yearService.queryYearList();

        model.addAttribute("movieTypes",movieTypes);
        model.addAttribute("adresses",adresses);
        model.addAttribute("movieYears",movieYears);
        return "movie/updateMovie";
}

    /**
     * 修改电影2  将修改的值保存到数据库
     */
      @RequestMapping("updateMovie")
      @ResponseBody
      public void updateMovie(Movie movie){
          movieService.updateMovie(movie);

      }

    /**
     * 删除
     */
    @RequestMapping("deleteMovie")
    @ResponseBody
    public void deleteMovie(Integer movieid){
      movieService.deleteMovie(movieid);
      }

    /**
     * 批量删除
     */
    @RequestMapping("delsMovie")
    @ResponseBody
    public void delsMovie(String ids){
        movieService.delsMovie(ids);
    }


}

