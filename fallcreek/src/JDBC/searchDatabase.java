package JDBC;

import java.sql.Connection;
import java.util.List;

import DAO.articleDao;
import DAOImpl.articleDaoImpl;
import entity.leetcode;
import entity.tag;
import util.ConnectionFactory;

public class searchDatabase {

	public static List<leetcode> getArticleList()
	{
		Connection conn = null;
		
		try {		
			ConnectionFactory cf = ConnectionFactory.getInstance();
			conn = cf.makeConnection();
			conn.setAutoCommit(false); //关闭事务的自动提交

			articleDao dao = new articleDaoImpl();
			return dao.getArticleList(conn);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<tag> getTagList()
	{
		Connection conn = null;
		
		try {		
			ConnectionFactory cf = ConnectionFactory.getInstance();
			conn = cf.makeConnection();
			conn.setAutoCommit(false); //关闭事务的自动提交

			articleDao dao = new articleDaoImpl();
			return dao.getTagList(conn);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<leetcode> getRecentArticleList()
	{
		Connection conn = null;
		
		try {		
			ConnectionFactory cf = ConnectionFactory.getInstance();
			conn = cf.makeConnection();
			conn.setAutoCommit(false); //关闭事务的自动提交

			articleDao dao = new articleDaoImpl();
			return dao.getRecentArticleList(conn);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}

