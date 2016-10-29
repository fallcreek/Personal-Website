package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class uploadaction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String user;
	
	public String execute()
	{
		if(user == null)
			return "fail";
		else if(user.equals("fallcreek"))
		{
			return "success";
		}
			
		else
			return "fail";
	}


	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
