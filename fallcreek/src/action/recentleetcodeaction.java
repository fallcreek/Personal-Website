package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import JDBC.searchDatabase;
import entity.leetcode;
import hibernate.hibernateinit;

public class recentleetcodeaction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<leetcode> recentArticle;
	private List<String> articleContent;
	
	final String articleLine = "<div class=\"article-line\">";
	final String articleId = "<div class=\"article-id\">";
	final String articleTitle = "<div class=\"article-title\">";
	final String articleDate = "<div class=\"article-date\">";
	final String end = "</div>";
	final String aEnd = "</a>";
	/*
	 * <div class="article-line">
		<div class="article-id">121</div>
		<div class="article-title">Power of Two</div>
		
		<blockquote><p>Given an integer, write a function to determine if it is a power of two.</p>
		
		<p>Difficulty: Easy</p>
		
		<p>Tag:Math;Bit Manipulation</p></blockquote>
		<div class="article-date">2016-6-12</div>
		</div>
	 * 
	 * */
	
	
	public List<leetcode> getRecentArticle() {
		return recentArticle;
	}

	public void setRecentArticle(List<leetcode> recentArticle) {
		this.recentArticle = recentArticle;
	}

	public List<String> getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(List<String> articleContent) {
		this.articleContent = articleContent;
	}

	public void returnContent()
	{
		setRecentArticle(searchDatabase.getRecentArticleList());
		setArticleContent(getArticleContents());
	    List<leetcode> recentArticles = getRecentArticle();
		List<String> articleContents = getArticleContent();
		
		/*
		 * <div class="article-line">
			<div class="article-id">121</div>
			<div class="article-title"><a href=""leetcode/" + id + ".html"">Power of Two</a></div>
			
			<blockquote><p>Given an integer, write a function to determine if it is a power of two.</p>
			
			<p>Difficulty: Easy</p>
			
			<p>Tag:Math;Bit Manipulation</p></blockquote>
			<div class="article-date">2016-6-12</div>
			</div>
		 * 
		 * */
		String result = "";
		for(int i = 0; i < articleContents.size(); i++)
		{
			leetcode article = recentArticles.get(i);
			String content = articleContents.get(i);
			String urlStart = "<a href=\"" + "leetcode/" + article.getId() + ".html\"" + ">";
			
			result += articleLine + articleId + article.getId() + end + articleTitle + urlStart + article.getTitle()
			+ aEnd + end + content + articleDate + article.getDate() + end + end;
		}
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		//向客户端传递数据
		try {
			ServletActionContext.getResponse().getWriter().print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<leetcode> getRecentArticles()
	{
		Session session = hibernateinit.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<leetcode> result = session.createQuery( "from leetcode order by date desc" ).list();
//			session.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<String> getArticleContents()
	{
		List<String> result = new ArrayList<String>();
		int number = 0;
		for(leetcode l : getRecentArticle())
		{
			number ++;
			int id = l.getId();
			String contextPath = ServletActionContext.getServletContext().getRealPath("/");
			//System.out.println(contextPath);
			String fileName = contextPath + "leetcode/" + id + ".html";
//			System.out.println(fileName);
			String content = readToString(fileName);
//			System.out.println(content);
			int startIndex = content.indexOf("<blockquote><p>");
			int endIndex = content.indexOf("</p></blockquote>");
			content = content.substring(startIndex, endIndex + 17);
			result.add(content);
			//System.out.println(content);
			
			if(number == 5)
				break;
		}
		
		return result;
	}
	
	public String readToString(String fileName) {
		String encoding = "utf-8";
		File file = new File(fileName);
		Long filelength = file.length();
		byte[] filecontent = new byte[filelength.intValue()];
		try {
			FileInputStream in = new FileInputStream(file);
			in.read(filecontent);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			return new String(filecontent, encoding);
		} catch (UnsupportedEncodingException e) {
			System.err.println("The OS does not support " + encoding);
			e.printStackTrace();
			return null;
		}
	}
}
