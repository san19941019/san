package com.huibo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.huibo.bo.ResultBo;
import com.huibo.po.Emp;
import com.huibo.service.EmpService;

@RestController
public class TestController {

  @Autowired
  private EmpService empService; 
 
 @GetMapping("/test")
 public String test() {
	 return "hello";
 }
 
 @GetMapping("/save")
 public void save(Emp emp) {
	 empService.save(emp);
 }
 
 @GetMapping("/selectAll")
 public ResultBo selectAll(Page<Emp> page) {
	 return empService.selectAll(page);
 }
}
