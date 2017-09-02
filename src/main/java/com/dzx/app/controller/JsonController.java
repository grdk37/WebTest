package com.dzx.app.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
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

import com.dzx.app.entity.Author;
import com.dzx.app.entity.AuthorExample;
import com.dzx.app.mapper.AuthorMapper;

@Controller
public class JsonController {

	@Resource
	AuthorMapper authorMapper;
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(){
		System.out.println("/login");
		return "login";
	}
	
	@RequestMapping(value="/hello",method = RequestMethod.GET)
	public String hello(){
		System.out.println("/hello");
		return "hello";
	}


	@RequestMapping(value = "/getString", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> test(ModelMap mv, HttpServletResponse response) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("a", "你好");
		map.put("b", 100);
		map.put("c", new Date());
		List list = Arrays.asList(200, "在这里", map);
		return new ResponseEntity<Object>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/select5", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> select(ModelMap mv, HttpServletResponse response) {
		System.out.println("-->");
		Map<String, Object> map = new LinkedHashMap<>();
		AuthorExample example = new AuthorExample();
		example.setOrderByClause("username asc");
		List<Author> list = authorMapper.selectByExample(example);
		return new ResponseEntity<Object>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/404", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> test404(ModelMap mv, HttpServletResponse response) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("code", "404");
		map.put("b", 404);
		map.put("c", new Date());
		List list = Arrays.asList(404, "在这里", map);
		return new ResponseEntity<Object>(list, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}
