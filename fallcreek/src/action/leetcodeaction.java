package action;

import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import JDBC.searchDatabase;
import entity.leetcode;
import entity.tag;
import hibernate.hibernateinit;

public class leetcodeaction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<leetcode> article;
	private List<leetcode> recentArticle;
	private List<String> articleContent;
	private List<tag> tagList;
	
	public List<leetcode> getArticleList()
	{
//		Session session = hibernateinit.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			List<leetcode> result = session.createQuery( "from leetcode" ).list();
////			session.close();
//			return result;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
		return searchDatabase.getArticleList();
	}
	
	public List<tag> returnTagList()
	{
		Session session = hibernateinit.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<tag> result = session.createQuery( "from tag" ).list();
//			session.close();
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
	
//	@SuppressWarnings("unchecked")
//	public List<leetcode> getRecentArticles()
//	{
//		Session session = hibernateinit.getSession();
//		try {
//			session.beginTransaction();
//			List<leetcode> result = session.createQuery( "from leetcode order by date desc" ).list();
//			session.close();
//			return result;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//	
//	public List<String> getArticleContents()
//	{
//		List<String> result = new ArrayList<String>();
//		
//		int number = 0;
//		for(leetcode l : getRecentArticle())
//		{
//			number ++;
//			int id = l.getId();
//			String contextPath = ServletActionContext.getServletContext().getRealPath("/");
//			String fileName = contextPath + "leetcode/" + id + ".html";
////			System.out.println(fileName);
//			String content = readToString(fileName);
////			System.out.println(content);
//			int startIndex = content.indexOf("<blockquote><p>");
//			int endIndex = content.indexOf("</p></blockquote>");
//			content = content.substring(startIndex, endIndex + 17);
//			result.add(content);
//			//System.out.println(content);
//			
//			if(number == 5)
//				break;
//		}
//		
//		return result;
//	}
//	
//	public String readToString(String fileName) {
//		String encoding = "utf-8";
//		File file = new File(fileName);
//		Long filelength = file.length();
//		byte[] filecontent = new byte[filelength.intValue()];
//		try {
//			FileInputStream in = new FileInputStream(file);
//			in.read(filecontent);
//			in.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		try {
//			return new String(filecontent, encoding);
//		} catch (UnsupportedEncodingException e) {
//			System.err.println("The OS does not support " + encoding);
//			e.printStackTrace();
//			return null;
//		}
//	}

//	public void destroy()
//	{
//		transaction.commit();
//		session.close();
//		sessionFactory.close();
//	}
	
	public String execute()
	{
		setArticle(searchDatabase.getArticleList());
		setTagList(searchDatabase.getTagList());
		//setRecentArticle(getRecentArticles());
		//setArticleContent(getArticleContents());
		if(getArticle() == null || getTagList() == null)
			return "fail";
		
		return "success";
	}
	


	public List<leetcode> getArticle() {
		return article;
	}

	public void setArticle(List<leetcode> article) {
		this.article = article;
	}

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

	public List<tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<tag> tagList) {
		this.tagList = tagList;
	}
}
