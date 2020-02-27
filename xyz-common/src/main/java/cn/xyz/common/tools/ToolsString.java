package cn.xyz.common.tools;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class ToolsString {
	public static JSONObject fileds = new JSONObject();
	static {
		fileds.put("emp_name", "displayname");
		fileds.put("empno", "userno");
		fileds.put("prod_ctr", "departmentno");
		fileds.put("arbpl", "workcenterNo");
		fileds.put("prod_des", "departmentname");
	}
	public static String filedConvert(String filed){
		if(fileds.containsKey(filed)) {
			return fileds.getString(filed);
		}
		return filed.toLowerCase().trim();
	}
	
	public static String format(Object obj) {
		return (obj == null) ? "" : obj.toString();
	}
	
	
	public static void main(String[] args) {
		String a = "123";
		System.out.println(Double.valueOf(a));
	}
}