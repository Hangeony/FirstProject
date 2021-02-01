package board.article.service;

import java.util.Map;

import board.article.model.Writer;

public class WriteArticleRequest {
	private Writer writer;
	private String title;
	private String Content;
	
	public Writer getWriter() {
		return writer;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return Content;
	}
	public WriteArticleRequest(Writer writer, String title, String content) {
		this.writer = writer;
		this.title = title;
		Content = content;
	}
	
	public void validate(Map<String, Boolean>errors) {
		if(title == null || title.trim().isEmpty()) {
			errors.put("title", true);
		}
	}
	
}
