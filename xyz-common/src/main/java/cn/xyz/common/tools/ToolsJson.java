package cn.xyz.common.tools;

import com.alibaba.fastjson.JSONObject;

public class ToolsJson {
	public static JSONObject removeKey(JSONObject row, Object...keys) throws Exception {
		if(Tools.isEmpty(row)) return null;
		JSONObject obj = (JSONObject)row.clone();
		if(!Tools.isEmpty(keys)) {
			for (int i = 0; i < keys.length; i++) {
				Object key = keys[i];
				if(key.getClass().isArray()){//用于keys是：String,String,String...(最后一个是数组)
					String[] o = (String[])key;
					for (int j = 0; j < o.length; j++) {
						row.remove(o[j].trim());
					}
				}else {
					String[] s = ((String)key).split(",");
					for (int j = 0; j < s.length; j++) {
						row.remove(s[j].trim());
					}
				}
			}
		}
		return obj;
	}
	//清除空格：用于表单提交前后有空格
	public JSONObject clearSpace(JSONObject row) {
		for(String key:row.keySet()){
			String value = row.getString(key);
			if(value != null) {
				row.put(key, value.trim());
			}
		}
		return row;
	}
	//清除空key
	public JSONObject clearNull(JSONObject row) throws Exception {
		for(String key:row.keySet()){
			String value = row.getString(key);
			if(Tools.isEmpty(value)) {
				row.remove(key);
			}
		}
		return row;
	}
	//把空字符串转为null：用于数字类型，空字符串不能添加
	public JSONObject toNull(JSONObject row) {
		for(String key:row.keySet()){
			String value = row.getString(key);
			if(value != null && value.trim() == "") {
				row.put(key, null);
			}
		}
		return row;
	}
	public static void main(String[] args) {
		JSONObject row = new JSONObject();
		row.put("a","111");
		row.put("b","222");
		String[] c = {"a","c"};
		try {
			//removeKey(row,DbTool.DEFAULT_REMOVE_KEYS,c);
			System.out.println(row);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}