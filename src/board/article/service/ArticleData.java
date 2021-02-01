package board.article.service;

import board.article.model.Article;

public class ArticleData {
	private Article article;
	
	public Article getArticle() {
		return article;
	}

	
	public ArticleData(Article article) {
		this.article = article;
	}
	
}
