package org.yuan.project.platform.model;

import java.util.HashMap;
import java.util.Map;

public class ResultJson {

	public ResultJson() {
		code = 0;
		info = "";
		data = new HashMap<String,Object>();
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	private Integer code;
	private String info;
	private Map<String,Object> data;
}
