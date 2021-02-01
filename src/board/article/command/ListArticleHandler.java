package board.article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.article.service.ArticlePage;
import board.article.service.ListArticleService;
import mvc.command.CommandHandler;

public class ListArticleHandler implements CommandHandler {
	private ListArticleService listService = new ListArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			String pageNoVal = req.getParameter("pageNo");
			int pageNo = 1;
			
			if(pageNoVal != null) {
				pageNo = Integer.parseInt(pageNoVal);
			}
			
			ArticlePage articlePage = listService.getArticlePage(pageNo);
			req.setAttribute("articlePage", articlePage);
			return "listArticle";
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			String pageNoVal = req.getParameter("pageNo");
			
//			System.out.println("Handler : "+ req.getParameter("searchType"));
//			System.out.println("Handler : "+ req.getParameter("keyword"));
			
			int pageNo = 1;
			
			if(pageNoVal != null) {
				pageNo = Integer.parseInt(pageNoVal);
			}
			
			ArticlePage articlePage = listService.getSearchArticlePage(pageNo, req.getParameter("searchType"), req.getParameter("keyword"));
			req.setAttribute("articlePage", articlePage);
			
			return "listArticle";
		}else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

}
