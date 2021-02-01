package board.article.model;

import java.util.Date;

public class Article {
	private Integer number;
	private Writer writer;
	private String title;
	private String content;
	private Date regDate;
	private Date modifiedDate;
	private int readCount;
	private int comment_count;
	
	public Integer getNumber() {
		return number;
	}
	public Writer getWriter() {
		return writer;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public int getComment_count() {
		return comment_count;
	}
	

	public Article(Integer number, Writer writer, String title, String content, Date regDate, Date modifiedDate,
			int readCount, int comment_count) {
		super();
		this.number = number;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.modifiedDate = modifiedDate;
		this.readCount = readCount;
		this.comment_count = comment_count;
	}
	
}
