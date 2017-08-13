package com.dzx.app.common;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GeneralHandler {

//	@ModelAttribute
//	public Date addAccount(@RequestParam String number) {
//		System.out.println("ModelAttribute");
//		return new Date();
//	}

	@ExceptionHandler(ServletRequestBindingException.class)
	@ResponseBody
	public ResponseEntity<Object> HandleBindException(ServletRequestBindingException ex) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("code", 404);
		map.put("content", "ServletRequestBindingException");
		System.out.println("GeneralHandler worked");
		return new ResponseEntity<Object>(map, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}