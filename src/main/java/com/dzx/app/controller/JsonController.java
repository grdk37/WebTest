package com.dzx.app.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JsonController {

	@RequestMapping(value = "/getString", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> test(ModelMap mv, HttpServletResponse response) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("a", "你好");
		map.put("b", 100);
		map.put("c", new Date());
		List list = Arrays.asList(200, "在这里", map);
		 return new ResponseEntity<Object>(list,new HttpHeaders(), HttpStatus.OK);
	}
	@RequestMapping(value = "/404", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> test404(ModelMap mv, HttpServletResponse response) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("a", "404");
		map.put("b", 100);
		map.put("c", new Date());
		List list = Arrays.asList(404, "在这里404", map);
		 return new ResponseEntity<Object>(list,new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}
