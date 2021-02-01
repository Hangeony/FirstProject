<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
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
--skinSvgIconSolidWriting: #009F47; 
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

section {
	display: block;
}

.WritingWrap {
	color: #000;
}

.WritingHeader {
	position: relative;
	margin-top: 20px;
	border-bottom: 1px solid #323232;
}

.BaseButton.size_default {
	min-width: 46px;
	height: 36px;
	margin-left: 10px;
	padding: 0 12px;
	font-size: 13px;
	line-height: 36px;
}

.BaseButton--skinGreen {
	background: var(-- skinBaseButtonPointBg);
	color: var(-- skinBaseButtonPointColor);
}

.BaseButton {
	display: inline-block;
	border-radius: 6px;
	box-sizing: border-box;
	font-weight: 700;
	text-align: center;
	vertical-align: top;
}

.WritingContent {
	position: relative;
	padding-top: 12px;
	padding-bottom: 50px;
}

.WritingEditor {
	float: left;
	width: 862px;
}

div {
	display: block;
}

.WritingWrap {
	color: #000;
}

.FlexableTextArea .textarea_input {
	display: block;
	width: 100%;
	min-height: 40px;
	padding: 11px 12px 10px;
	border: 1px solid #ebecef;
	box-sizing: border-box;
	overflow: hidden;
	resize: none;
	word-break: break-all;
	font-size: 15px;
	letter-spacing: -.23px;
	line-height: 17px;
	outline: none;
}

.CafeEditor {
	margin-top: 12px;
	border: 1px solid #ebecef;
	border-bottom: 0;
	background: #fff;
}
</style>
</head>
<body>
<u:navbar/>
<%--
	<div class="container">
		<form action="write.do" method="post">
			<p>
				제목 <br /> <input type="text" name="title" value="${param.title }" />
			</p>
			<p>
				내용 <br />
				<textarea name="content" id="" cols="30" rows="5">${param.content }</textarea>
			</p>
			<input type="submit" value="글 등록" />
		</form>
	</div>
 --%>
	<section class="container">
		<form action="write.do" method="post">
			<div class="WritingWrap">
				<div class="WritingHeader">
					<h3>글쓰기</h3>
					<button class="btn btn-success">등록</button>
				</div>
			</div>
			<div class="WritingContent">
				<div class="WritingEditor">
					<div class="ArticleWritingTitle">
						<div class="FlexableTextArea">
							<textarea placeholder="제목을 입력하세요." class="textarea_input" style="height: 40px;" name="title">${param.title }</textarea>
						</div>
					</div>
					<div class="CafeEditor">
						<div class="FlexableTextArea">
							<textarea  placeholder="내용을 입력하세요"  class="textarea_input" name="content" style="height:480px;" >${param.content }</textarea>
						</div>
					</div>
				</div>
			</div>
		</form>
	</section>
</body>
</html>