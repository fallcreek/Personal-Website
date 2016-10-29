package action;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class testaction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String path;
	
	public String execute()
	{
		HttpServletRequest req = (HttpServletRequest) ServletActionContext.getRequest();
		HttpServletResponse resq = (HttpServletResponse) ServletActionContext.getResponse();
		
		String realPath = req.getSession().getServletContext().getRealPath("/");
		setPath(realPath);
		
		System.out.println(realPath);
		
		return "success";
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
