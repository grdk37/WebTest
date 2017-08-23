package com.dzx.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;  

@Controller
public class BaseNameController extends AbstractController {  
  
    @Override  
    protected ModelAndView handleRequestInternal(HttpServletRequest request,  
            HttpServletResponse response) throws Exception {  
         ModelAndView mv = new ModelAndView();  
        mv.addObject("message", "这是SimpleUrlController");  
        mv.addObject("errorMessage", "这是SimpleUrlController");  
        mv.setViewName("index");  
        return mv;  

    }  
  
}