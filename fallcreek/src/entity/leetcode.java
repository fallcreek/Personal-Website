package entity;

import java.sql.Date;

public class leetcode {
	private int id;
	private String title;
	private String difficulty;
	private String tag;
	private Date date;
	
	
	public leetcode(){
		
	}

	public leetcode(int id, String title, String difficulty, String tag, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.difficulty = difficulty;
		this.tag = tag;
		this.date = date;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
