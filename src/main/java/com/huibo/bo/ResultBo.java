package com.huibo.bo;

import java.util.HashMap;


public class ResultBo extends HashMap<String, Object>{

	private static final long serialVersionUID = -7150385849477124822L;
	
	public static ResultBo getInstance() {
		ResultBo rb = new ResultBo();
		rb.put("code", 200);
		return rb;
	}
	
	public ResultBo put(String key,Object value) {
		super.put(key, value);
		return this;
	}
	

}
