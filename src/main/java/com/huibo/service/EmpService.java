package com.huibo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huibo.bo.ResultBo;
import com.huibo.dao.EmpDao;
import com.huibo.po.Emp;

@Service
public class EmpService {
     
	@Autowired
	private EmpDao empDao;
	
	public int save(Emp emp) {
		return empDao.save(emp);
	}
	
	public ResultBo selectAll(Page<Emp> page){
		PageHelper.startPage(page.getPageNum(),page.getPageSize());
		List<Emp> list=empDao.selectAll();
		PageInfo<Emp> pageInfo=new PageInfo<Emp>(list);
		return ResultBo.getInstance().put("list", list).put("total", pageInfo.getTotal());
		 
	 }
}
