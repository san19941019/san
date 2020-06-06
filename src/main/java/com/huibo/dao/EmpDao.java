package com.huibo.dao;

import java.util.List;
import com.huibo.po.Emp;

public interface EmpDao {
    
   int save(Emp emp);	
   List<Emp> selectAll();
}
