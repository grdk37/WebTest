package com.dzx.app.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dzx.app.entity.Blog;
import com.dzx.app.mapper.BlogMapper;

@Controller
@RequestMapping("/blog")
public class BlogController {
	@Resource
	BlogMapper blogMapper;

	@RequestMapping(value = "/select", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> test(ModelMap mv, HttpServletResponse response) {
		Map<String, Object> map = new LinkedHashMap<>();
		Blog blog=blogMapper.selectBlogDetails(1);
		map.put("blog", blog);
		map.put("code", 200);
	
		return new ResponseEntity<Object>(map, new HttpHeaders(), HttpStatus.OK);
	}
	

}
