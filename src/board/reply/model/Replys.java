package board.reply.model;

public class Replys {
	private int replyId;
	private int articleId;
	private String memberId;
	private String replycontent;
	private int groupId;
	private int parentReplyId;
	private int orderNo;
	private int depth;
	
	public int getReplyId() {
		return replyId;
	}
	public int getArticleId() {
		return articleId;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getReplycontent() {
		return replycontent;
	}
	public int getGroupId() {
		return groupId;
	}
	public int getParentReplyId() {
		return parentReplyId;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public int getDepth() {
		return depth;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public void setParentReplyId(int parentReplyId) {
		this.parentReplyId = parentReplyId;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	
	

	
}
