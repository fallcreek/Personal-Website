package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import entity.leetcode;
import hibernate.hibernateinit;

public class updateaction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String password;
	private String id;
	private String title;
	private String difficulty;
	private String tag;
	private String date;

	private File html;
	private String htmlFileName;
	private String htmlContentType;
	
	private File algorithm1;
	private String algorithm1FileName;
	private String algorithm1ContentType;
	private File runtime1;
	private String runtime1FileName;
	private String runtime1ContentType;
	
	private File algorithm2;
	private String algorithm2FileName;
	private String algorithm2ContentType;
	private File runtime2;
	private String runtime2FileName;
	private String runtime2ContentType;
	
	private File algorithm3;
	private String algorithm3FileName;
	private String algorithm3ContentType;
	private File runtime3;
	private String runtime3FileName;
	private String runtime3ContentType;
	
	public String execute()
	{
		System.out.println("updateaction");
		
		System.out.println(password);
		System.out.println(id);
		System.out.println(title);
		System.out.println(difficulty);
		System.out.println(tag);
		System.out.println(date);
		
		if(!password.equals( "Nietianhui0502"))
			return "fail";
		
		HttpServletRequest req = (HttpServletRequest) ServletActionContext.getRequest();

		String realPath = req.getSession().getServletContext().getRealPath("/");
		
		
		if(htmlFileName.length() != 0)
		{		
			String path = realPath + "leetcode/" + getId() + ".html";
			
			upload(getHtml(),path);
		}
		
		if(algorithm1FileName.length() != 0)
		{		
			String path = realPath + "img/leetcode/" + getId() + "-algorithm-1.png";
			
			upload(getAlgorithm1(),path);
		}
		
		if(runtime1FileName.length() != 0)
		{		
			String path = realPath + "img/leetcode/" + getId() + "-runtime-1.png";
			
			upload(getRuntime1(),path);
		}
		
		if(algorithm2FileName.length() != 0)
		{		
			String path = realPath + "img/leetcode/" + getId() + "-algorithm-2.png";
			
			upload(getAlgorithm2(),path);
		}
		
		if(runtime2FileName.length() != 0)
		{		
			String path = realPath + "img/leetcode/" + getId() + "-runtime-2.png";
			
			upload(getRuntime2(),path);
		}
		
		if(algorithm3FileName.length() != 0)
		{		
			String path = realPath + "img/leetcode/" + getId() + "-algorithm-3.png";
			
			upload(getAlgorithm3(),path);
		}
		
		if(runtime3FileName.length() != 0)
		{		
			String path = realPath + "img/leetcode/" + getId() + "-runtime-3.png";
			
			upload(getRuntime3(),path);
		}
		
		if(id.length() != 0)
		{
			leetcode article = new leetcode(Integer.valueOf(id),title,difficulty,tag,Date.valueOf(date));
			
			Session session = hibernateinit.getSessionFactory().getCurrentSession();
			try {
				Transaction tx = session.beginTransaction();
				session.save(article);
				tx.commit();
				session.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "fail";
			}
		}
			
		
		return "success";
	}
	
	public void upload(File file, String path)
	{
		InputStream is;
		try {
			is = new FileInputStream(file);
			OutputStream os = new FileOutputStream(path);
			byte buffer[] = new byte[1024];
			int count = 0;
			while((count = is.read(buffer)) > 0)
			{
				os.write(buffer, 0, count);
			}
			os.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("upload error!");
		}
	}
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}


	public String getTag() {
		return tag;
	}


	public void setTag(String tag) {
		this.tag = tag;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}

	public File getHtml() {
		return html;
	}

	public void setHtml(File html) {
		this.html = html;
	}

	public String getHtmlFileName() {
		return htmlFileName;
	}

	public void setHtmlFileName(String htmlFileName) {
		this.htmlFileName = htmlFileName;
	}

	public String getHtmlContentType() {
		return htmlContentType;
	}

	public void setHtmlContentType(String htmlContentType) {
		this.htmlContentType = htmlContentType;
	}

	public File getAlgorithm1() {
		return algorithm1;
	}

	public void setAlgorithm1(File algorithm1) {
		this.algorithm1 = algorithm1;
	}


	public File getRuntime1() {
		return runtime1;
	}

	public void setRuntime1(File runtime1) {
		this.runtime1 = runtime1;
	}

	public String getRuntime1FileName() {
		return runtime1FileName;
	}

	public void setRuntime1FileName(String runtime1FileName) {
		this.runtime1FileName = runtime1FileName;
	}

	public String getRuntime1ContentType() {
		return runtime1ContentType;
	}

	public void setRuntime1ContentType(String runtime1ContentType) {
		this.runtime1ContentType = runtime1ContentType;
	}

	public File getAlgorithm2() {
		return algorithm2;
	}

	public void setAlgorithm2(File algorithm2) {
		this.algorithm2 = algorithm2;
	}


	public File getRuntime2() {
		return runtime2;
	}

	public void setRuntime2(File runtime2) {
		this.runtime2 = runtime2;
	}

	public String getRuntime2FileName() {
		return runtime2FileName;
	}

	public void setRuntime2FileName(String runtime2FileName) {
		this.runtime2FileName = runtime2FileName;
	}

	public String getRuntime2ContentType() {
		return runtime2ContentType;
	}

	public void setRuntime2ContentType(String runtime2ContentType) {
		this.runtime2ContentType = runtime2ContentType;
	}

	public File getAlgorithm3() {
		return algorithm3;
	}

	public void setAlgorithm3(File algorithm3) {
		this.algorithm3 = algorithm3;
	}


	public String getAlgorithm1FileName() {
		return algorithm1FileName;
	}

	public void setAlgorithm1FileName(String algorithm1FileName) {
		this.algorithm1FileName = algorithm1FileName;
	}

	public String getAlgorithm1ContentType() {
		return algorithm1ContentType;
	}

	public void setAlgorithm1ContentType(String algorithm1ContentType) {
		this.algorithm1ContentType = algorithm1ContentType;
	}

	public String getAlgorithm2FileName() {
		return algorithm2FileName;
	}

	public void setAlgorithm2FileName(String algorithm2FileName) {
		this.algorithm2FileName = algorithm2FileName;
	}

	public String getAlgorithm2ContentType() {
		return algorithm2ContentType;
	}

	public void setAlgorithm2ContentType(String algorithm2ContentType) {
		this.algorithm2ContentType = algorithm2ContentType;
	}

	public String getAlgorithm3FileName() {
		return algorithm3FileName;
	}

	public void setAlgorithm3FileName(String algorithm3FileName) {
		this.algorithm3FileName = algorithm3FileName;
	}

	public String getAlgorithm3ContentType() {
		return algorithm3ContentType;
	}

	public void setAlgorithm3ContentType(String algorithm3ContentType) {
		this.algorithm3ContentType = algorithm3ContentType;
	}

	public File getRuntime3() {
		return runtime3;
	}

	public void setRuntime3(File runtime3) {
		this.runtime3 = runtime3;
	}

	public String getRuntime3FileName() {
		return runtime3FileName;
	}

	public void setRuntime3FileName(String runtime3FileName) {
		this.runtime3FileName = runtime3FileName;
	}

	public String getRuntime3ContentType() {
		return runtime3ContentType;
	}

	public void setRuntime3ContentType(String runtime3ContentType) {
		this.runtime3ContentType = runtime3ContentType;
	}





}
