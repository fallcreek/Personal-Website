package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.articleDao;
import entity.leetcode;
import entity.tag;

public class articleDaoImpl implements articleDao {

	@Override
	public List<leetcode> getArticleList(Connection conn) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("select * from article");
		
		ResultSet rs = ps.executeQuery(); //执行query
				
		rs.last(); //移到最后一行   
		int rowCount = rs.getRow(); //得到当前行号，也就是记录数   
		rs.beforeFirst();
		
		if(rowCount == 0)
		{
			System.out.println("查询不到任何文章");
			rs.close();
			ps.close();
			conn.close();
			
			return null;
		}
		
		List<leetcode> articleList = new ArrayList<leetcode>();
		
		while(rs.next())
		{
			leetcode article = new leetcode();
			article.setId(rs.getInt(1));
			article.setTitle(rs.getString(2));
			article.setDifficulty(rs.getString(3));
			article.setTag(rs.getString(4));
			article.setDate(rs.getDate(5));
			articleList.add(article);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return articleList;
		
	}

	@Override
	public List<tag> getTagList(Connection conn) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("select * from tag");
		
		ResultSet rs = ps.executeQuery(); //执行query
				
		rs.last(); //移到最后一行   
		int rowCount = rs.getRow(); //得到当前行号，也就是记录数   
		rs.beforeFirst();
		
		if(rowCount == 0)
		{
			System.out.println("查询不到任何tag");
			rs.close();
			ps.close();
			conn.close();
			
			return null;
		}
		
		List<tag> tagList = new ArrayList<tag>();
		
		while(rs.next())
		{
			tag t = new tag();
			t.setId(rs.getInt(1));
			t.setName(rs.getString(2));
			tagList.add(t);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return tagList;
	}

	@Override
	public List<leetcode> getRecentArticleList(Connection conn) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("select * from article order by date desc limit 5");
		
		ResultSet rs = ps.executeQuery(); //执行query
				
		rs.last(); //移到最后一行   
		int rowCount = rs.getRow(); //得到当前行号，也就是记录数   
		rs.beforeFirst();
		
		if(rowCount == 0)
		{
			System.out.println("查询不到任何文章");
			rs.close();
			ps.close();
			conn.close();
			
			return null;
		}
		
		List<leetcode> articleList = new ArrayList<leetcode>();
		
		while(rs.next())
		{
			leetcode article = new leetcode();
			article.setId(rs.getInt(1));
			article.setTitle(rs.getString(2));
			article.setDifficulty(rs.getString(3));
			article.setTag(rs.getString(4));
			article.setDate(rs.getDate(5));
			articleList.add(article);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return articleList;
	}

}
