/** 
 * <pre>项目名称:ssm-book-java123 
 * 文件名称:PageController.java 
 * 包名:com.ytc.controller 
 * 创建日期:2020年8月31日上午9:20:41 
 * Copyright (c) 2020,  All Rights Reserved.</pre> 
 */  
package com.ytc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * <pre>项目名称：ssm-book-java123    
 * 类名称：PageController    
 * 类描述：    
 * 创建人：zyl   
 * 创建时间：2020年8月31日 上午9:20:41    
 * 修改人：zyl 
 * 修改时间：2020年8月31日 上午9:20:41    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("/page")
public class PageController {

	@RequestMapping("top")
	public String top(){
		return "frameset/top";
	}
	
	@RequestMapping("left")
	public String left(){
		return "frameset/left";
	}
	@RequestMapping("center")
	public String center(){
		return "frameset/center";
	}
}
