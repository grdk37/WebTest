package com.dzx.app.controller;

import java.util.Arrays;
import java.util.HashMap;
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
import com.dzx.app.mapper.AuthorMapper;

@Controller
@RequestMapping("/author")
public class AuthorController {
	@Resource
	AuthorMapper authorMapper;

	@RequestMapping(value = "/select5", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> test(ModelMap mv, HttpServletResponse response) {
		Map<String, Object> map = new LinkedHashMap<>();
		Author author=authorMapper.selectAuthor2(103);
		map.put("author", author);
		HashMap map2=authorMapper.selectAuthor3("jamie");
		List list = Arrays.asList(200, author, map,map2);
		return new ResponseEntity<Object>(list, new HttpHeaders(), HttpStatus.OK);
	}
	

}
