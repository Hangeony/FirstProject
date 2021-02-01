<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
:root {
  --skinTextColor: #000000;
  --skinText323232: #323232;
  --skinText676767: #676767;
  --skinText979797: #979797;
  --skinTextb7b7b7: #b7b7b7;
  --GnbLink: #333;
  --GnbLinkBar: #e5e5e5;
  --GnbLinkArrow: #777;
  --LayoutHeaderTitleBg: url(https://ssl.pstatic.net/static/cafe/cafe_pc/bg_default_title_white_180724.png);
  --LayoutHeaderTitleName: #212121;
  --LayoutHeaderTitleUrl: #666;
  --skinListBorder: #f2f2f2;
  --skinThumbBorder: rgba(0, 0, 0, 0.06);
  --skinBar: rgba(0, 0, 0, 0.15);
  --skinArticleLink: -webkit-link;
  --skinSourceBadge: #323232;
  --skinTagLinkColor: #323232;
  --skinToggleSwitchBg: #a7a7a7;
  --skinTempSaveBorder: rgba(0, 0, 0, 0.2);
  --skinCommentWriterBorder: rgba(0, 0, 0, 0.1);
  --skinCommentWriterBg: #ffffff;
  --skinCommentWriterText: #b7b7b7;
  --skinCommentWriterFocus: #eeeeee;
  --skinBox: #f9f9fa;
  --skinSvgIconPostBtnArrowUp: #323232;
  --skinSvgIconPostTop: #323232;
  --skinLayoutBorder: #ebecef;
  --skinBaseButtonDefaultBg: #eff0f2;
  --skinBaseButtonDefaultColor: #000000;
  --skinBaseButtonPointBg: rgba(3, 199, 90, 0.12);
  --skinBaseButtonPointColor: #009f47;
  --skinBgPostRefresh: url(https://ca-fe.pstatic.net/web-pc/static/img/ico-post-refresh.svg?f332c2e…);
  --skinSvgIconNpay: url(https://ca-fe.pstatic.net/web-pc/static/img/pc-ico-npay.svg?d0a9d54…);
  --skinSvgIconSolidWriting: #009f47;
  --skinColor: #ffffff;
  --skinCommentMineBg: #f9f9fa;
  --skinListSelectedBg: #f9f9fa;
  --skinBaseButtonDefaultBorder: transparent;
  --skinCommentRefreshButtonBorder: transparent;
  --skinNoticeBadgeRequiredBg: #ffe3e4;
  --skinNoticeBadgeMenuBg: #ffffff;
  --skinNoticeBadgeMenuBorder: #ffe3e4;
  --skinNoticeBadgeColor: #f53535;
}

dl, ol, ul {
	list-style: none;
}

.ArticleContentBox {
	padding: 29px 29px 0;
	border: 1px solid var(- -skinLayoutBorder);
	border-radius: 6px;
}

.ArticleContentBox .article_header {
	position: relative;
	margin-bottom: 20px;
	padding-bottom: 20px;
	border-bottom: 1px solid var(- -skinLayoutBorder);
}

.ArticleTitle {
	margin-bottom: 12px;
	font-size: 13px;
}

.ArticleTitle .title_area {
	margin-top: 7px;
}

.ArticleTitle .title_area .title_category {
	position: relative;
	float: left;
	margin-right: 8px;
}

.Article .article_wrap {
	position: relative;
	width: 860px;
	margin: 0 auto;
	font-size: 12px;
}

.WriterInfo {
	display: flex;
}

.WriterInfo .profile_area {
	float: left;
}

.WriterInfo .profile_info .nick_box {
	display: inline-block;
	position: relative;
	vertical-align: top;
}

.WriterInfo .article_info {
	font-size: 12px;
	line-height: 13px;
	color: var(- -skinText979797);
}

.ArticleTool {
	position: absolute;
	right: 0;
	bottom: 28px;
	font-size: 13px;
	line-height: 18px;
}

.ReplyBox {
	position: relative;
	margin-bottom: 27px;
	line-height: 19px;
}

.ReplyBox .button_comment {
	display: inline-block;
	vertical-align: top;
	font-size: 13px;
}

.ArticleTitle .title_area .title_text {
	font-weight: 400;
	font-size: 26px;
	word-break: break-all;
	word-wrap: break-word;
	word-break: break-word;
}

.CommentBox {
	margin-top: -17px;
	border-top: 1px solid var;
}

.CommentBox .comment_option {
	position: relative;
	padding-top: 20px;
	margin-bottom: 11px;
}

.CommentBox .comment_option .comment_title {
	float: left;
	margin-top: 3px;
	margin-right: 12px;
	font-size: 17px;
}

.CommentBox .comment_list .CommentItem:first-child {
	border-top: 0;
	margin-top: 50px;
}

.CommentBox .comment_list .CommentItem {
	position: relative;
	border-top: 1px solid var(--skinListBorder);
}

.CommentBox .comment_list .comment_thumb {
	position: absolute;
	top: 12px;
	left: 0;
	width: 36px;
	height: 36px;
}

.CommentBox .comment_list .comment_area {
	position: relative;
	padding: 12px 23px 10px 0;
}

.CommentBox .comment_list .comment_thumb:after {
	content: "";
	border: 1px solid var(- -skinThumbBorder);
	border-radius: 50%;
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
}

.CommentBox .comment_list .comment_box {
	padding-left: 46px;
}

.CommentBox .comment_list .comment_nick_box {
	margin-bottom: 4px;
}

.CommentBox .comment_list .comment_nick_box .comment_nick_info {
	display: inline-block;
	position: relative;
	font-size: 13px;
	vertical-align: top;
}

.CommentBox .comment_list .comment_text_box {
	position: relative;
	font-size: 13px;
	word-break: break-all;
	word-wrap: break-word;
}

.CommentBox .comment_list .comment_text_box .comment_text_view {
	overflow: hidden;
}

.CommentBox .comment_list .comment_text_box .text_comment {
	line-height: 17px;
	word-break: break-all;
	word-wrap: break-word;
	vertical-align: top;
}

.CommentBox .comment_list .comment_info_box {
	margin-top: 7px;
	font-size: 12px;
	color: var(- -skinText979797);
}

.CommentBox a {
	color: inherit;
}

.CommentBox .comment_list+.CommentWriter {
	margin-top: 10px;
}

.CommentWriter {
	margin: 12px 0 29px;
	padding: 16px 10px 10px 18px;
	border: 2px solid var(- -skinCommentWriterBorder);
	border-radius: 6px;
	box-sizing: border-box;
	background: var(- -skinCommentWriterBg);
}

.CommentWriter .comment_inbox {
	position: relative;
	margin-bottom: 10px;
}

element.style {
	overflow: hidden;
	overflow-wrap: break-word;
	height: 17px;
}

.CommentWriter .comment_attach {
	position: relative;
}

.CommentWriter .register_box {
	float: right;
}
.CommentBox .comment_list + .CommentWriter {
  margin-top: 10px;
}

.CommentWriter {
  margin: 12px 0 29px;
  padding: 16px 10px 10px 18px;
  border: 2px solid var(--skinCommentWriterBorder);
  border-radius: 6px;
  box-sizing: border-box;
  background: var(--skinCommentWriterBg);
  margin-top: 40px !important;
}

.CommentWriter .comment_inbox {
  position: relative;
  margin-bottom: 10px;
}

.blind {
  position: absolute;
  clip: rect(0 0 0 0);
  width: 1px;
  height: 1px;
  margin: -1px;
  overflow: hidden;
}

.CommentWriter .comment_inbox_name {
  display: block;
  margin-bottom: 10px;
  font-weight: 700;
  font-size: 13px;
}

.CommentWriter .comment_inbox_text {
  overflow-x: hidden;
  overflow-y: auto;
  display: block;
  width: 100%;
  min-height: 17px;
  padding-right: 1px;
  border: 0;
  font-size: 13px;
  -webkit-appearance: none;
  resize: none;
  box-sizing: border-box;
  background: transparent;
  color: var(--skinTextColor);
  outline: 0;
}

.CommentWriter .comment_attach {
  padding-bottom: 30px;
  position: relative;
}

.CommentWriter .register_box {
  float: right;
}

.CommentWriter .register_box .button {
  display: inline-block;
  min-width: 46px;
  height: 34px;
  line-height: 36px;
  font-size: 13px;
  color: var(--skinCommentWriterText);
  border-radius: 6px;
  box-sizing: border-box;
  font-weight: 700;
  text-align: center;
  vertical-align: top;
  text-decoration: none;
}
.CommentBox
        .comment_list
        .CommentItem.CommentItem--reply
        + .CommentItem--reply {
        padding-left: 0;
        margin-left: 46px;
      }
</style>
</head>
<body>
<u:navbar/>
	<div class="container">
		<div class="ArticleContentBox">
			<div class="article_header">
				<div class="ArticleTitle">
					<div class="title_area">
						<h3 class="title_text">
						<%--
						 	${articleData.article.number }
						 --%>
						
							<c:out value="${articleData.article.title }" />
						</h3>
					</div>
				</div>
				<div class="WriterInfo">
					<a href="https://cafe.naver.com/CafeMemberNetworkView.nhn?m=view&amp;clubid=11276312&amp;memberid=m901224" class="thumb"> 
						<img src="https://ssl.pstatic.net/static/cafe/cafe_pc/default/cafe_profile_77.png?type=c77_77" alt="프로필 사진" width="36" height="36"></a>
					<div class="profile_area" style="margin-left: 20px;">
						<div class="profile_info">
							<div class="nick_box">
								<a href="javascript:void(0)" role="button" class="nickname">
									${articleData.article.writer.name } </a>
							</div>
						</div>
						<div class="article_info">
							<span class="count"> 조회 ${articleData.article.readCount }</span>
						</div>
					</div>
				</div>
				<div class="ArticleTool">
				<c:set var="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" />
				<a href="list.do?pageNo=${pageNo }"	role="button" class="button_comment"> <strong class="num">목록</strong>
					</a>
					<c:if test="${authUser.id == articleData.article.writer.id }">
						<a href="modify.do?no=${articleData.article.number }">게시글 수정</a>
						<a href="delete.do?no=${articleData.article.number }">게시물 삭제</a>
					</c:if>
				</div>
			</div>
			<div class="article_container">
				<div class="article_viewer">
					<div>
						<div class="content CafeViewer">
							<u:pre value="${articleData.article.content }" />
						</div>
						<div class="AttachFileIssueLayer" style="display: none;">
						</div>
					</div>
				</div>
				<div class="ReplyBox">
					<div class="box_left"></div>
				</div>
				<div class="CommentBox">
					<div class="comment_option">
						<h3 class="comment_title">댓글</h3>
					</div>
					<ul class="comment_list">
					<c:forEach items="${replyList}" var="reply">
						<li id="316520154" class="CommentItem" style="padding-left: ${reply.depth * 40 }px;">
						<div class="comment_area">
								<a href="https://cafe.naver.com/CafeMemberNetworkView.nhn?m=view&amp;clubid=11276312&amp;memberid=m901224" class="comment_thumb">
								<img src="https://ssl.pstatic.net/static/cafe/cafe_pc/default/cafe_profile_77.png?type=c77_77" alt="프로필 사진" width="36" height="36"></a>
								<div class="comment_box">
									<div class="comment_nick_box">
										<div class="comment_nick_info">
											<a id="cih316520154" href="#" role="button" aria-haspopup="true" aria-expanded="false" class="comment_nickname"> ${reply.memberId } </a>
										</div>
									</div>
									<div class="comment_text_box">
										<p class="comment_text_view">

											<span class="text_comment">${reply.replycontent}</span>
										</p>

									</div>
									<div class="comment_info_box">
									<button id="reply" type="button" class="comment_info_button" > 답글쓰기 </button>
									</div>
								</div>
							</div>
						</li>
					</c:forEach>
					</ul>
					<div data-v-79bd409c="" class="CommentWriter">
					<form id ="replyForm" action="${root }/reply/add.do" method="post" >
								<input type="hidden" id="articleId" name="articleId" value="${articleData.article.number}" />
                				<input type="hidden" id="depth" name="depth" value="0" />
                				<input type="hidden" id="parentReplyId" name="parentReplyId" value="0" />
                				<input type="hidden" id="groupId" name="groupId" value="0" />
                				<input type="hidden" id="orderNo" name="orderNo" value="0" />
                				<input type="hidden" id="replyId" name="replyId" value="0" />
                				<input type="hidden" name="pageNum" value="${param.pageNo }" />
						<div data-v-79bd409c="" class="comment_inbox">
							<strong data-v-79bd409c="" class="blind">댓글을 입력하세요</strong>
						<c:if test="${authUser.id }">
						<em data-v-79bd409c="" class="comment_inbox_name">${authUser.id}</em>
					   </c:if>
							<textarea data-v-79bd409c="" name="replycontent"  placeholder="댓글을 남겨보세요" rows="1" class="comment_inbox_text"></textarea>
						</div>
						<div data-v-79bd409c="" class="comment_attach">
							<div data-v-79bd409c="" class="register_box">
								<button id="btn" class="button btn_register" type="submit" style="border: none; background: transparent;">등록</button>
							</div>
						</div>
					</form>
					</div>
			
				</div>
			</div>
		</div>
	</div>
<script>
      $("#reply")
        .off()
        .on("click", function (event) {
          var $parentLi = $(event.currentTarget).parents("li");
          var form =
            '<li class="CommentItem CommentItem--reply">' +
            '<div data-v-79bd409c="" class="CommentWriter">' +
            '<form  action="${root }/reply/add.do" method="post">' +
            "<input" +
            ' type="hidden"' +
            '  id="articleId"' +
            '  name="articleId"' +
            '  value="${articleData.article.number}"' +
            "/>" +
            '<input type="hidden" id="depth" name="depth" value="0" />' +
            "<input" +
            '  type="hidden"' +
            '  id="parentReplyId"' +
            '  name="parentReplyId"' +
            '  value="0"' +
            "/>" +
            '<input type="hidden" id="groupId" name="groupId" value="0" />' +
            '<input type="hidden" id="orderNo" name="orderNo" value="0" />' +
            '<input type="hidden" id="replyId" name="replyId" value="0" />' +
            '<div data-v-79bd409c="" class="comment_inbox">' +
            '  <strong data-v-79bd409c="" class="blind"' +
            "    >댓글을 입력하세요</strong" +
            "  >" +
            '  <em data-v-79bd409c="" class="comment_inbox_name"' +
            "    >${authUser.id}</em" +
            "  >" +
            "  <textarea" +
            '    data-v-79bd409c=""' +
            '    name="replycontent"' +
            '    placeholder="댓글을 남겨보세요"' +
            '    rows="1"' +
            '   class="comment_inbox_text"' +
            "  ></textarea>" +
            "</div>" +
            '<div data-v-79bd409c="" class="comment_attach">' +
            '  <div data-v-79bd409c="" class="register_box">' +
            "    <button" +
            '      id="btn"' +
            '      class="button btn_register"' +
            '      type="submit"' +
            '     style="border: none; background: transparent;"' +
            "    >" +
            "      등록" +
            "    </button>" +
            "  </div>" +
            "</div>" +
            "</form>" +
            "</div>" +
            "</li>";
          $parentLi.after(form);
        });
    </script>
</body>
</html>