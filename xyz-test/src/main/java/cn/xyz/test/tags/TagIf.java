package cn.xyz.test.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagIf extends SimpleTagSupport{
	private String role;
	private String permission;
	
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println(this.role);
		System.out.println(this.permission);
		JspWriter out = getJspContext().getOut();
		try {
			out.write("<h3>"+this.role+"--"+this.permission+"</h3>");
			if("admin".equalsIgnoreCase(this.role) || "find".equalsIgnoreCase(this.permission)) {
				getJspBody().invoke(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPermission() {
		return this.permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
}
