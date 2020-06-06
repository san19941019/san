package com.huibo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MyExceptionHandler implements ErrorController{

	 private ObjectMapper om=new ObjectMapper();
	 
	 @Autowired
	 private ErrorAttributes eb;
	
	@RequestMapping("/error")
	public String excHandle(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		WebRequest er=new ServletWebRequest(req);
		Throwable  e=eb.getError(er);
		if(e==null){
			return null;
		}else {
		System.out.println("异常"+e.getClass().getName());
		String xhr=req.getHeader("X-Requested-With");
		if(xhr==null||xhr.trim().equals("")||!xhr.trim().equals("XMLHttpRequest")) {
		return "/error.html";		}else {
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("code", 500);
			map.put("msg", e.getMessage());
			map.put("data",e);
			resp.setStatus(200);
			resp.setContentType("application/json;charset=utf-8");
			resp.setCharacterEncoding("utf-8");
			String json=om.writeValueAsString(map);
			resp.getWriter().write(json);
			resp.getWriter().flush();;
			return null;}
		}
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}
}
