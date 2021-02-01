package board.article.service;

public class DeleteRequest {
	private int no;
	private String userId;
	
	public int getNo() {
		return no;
	}
	public String getUserId() {
		return userId;
	}
	
	public DeleteRequest(int no, String userId) {
		this.no = no;
		this.userId = userId;
	}
	
	
	

}
