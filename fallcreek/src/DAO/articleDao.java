package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entity.leetcode;
import entity.tag;

public interface articleDao {
	public List<leetcode> getArticleList(Connection conn) throws SQLException;
	public List<tag> getTagList(Connection conn) throws SQLException;
	public List<leetcode> getRecentArticleList(Connection conn) throws SQLException;
}
