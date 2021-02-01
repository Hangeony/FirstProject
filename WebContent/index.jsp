<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<meta charset="UTF-8">
<title>This is first project</title>
</head>
<style>
        body {
	 font-family: 'Montserrat', sans-serif;
	 color: #ffff;
         background: #54D3F9;
         background: -webkit-linear-gradient(top left, #54D3F9, #605BFF);
         background: -moz-linear-gradient(top left, #54D3F9, #605BFF);
         background: linear-gradient(top left, #54D3F9, #605BFF);
         }
		 
         .container {
          height: 100%;
          width: 100%;
          display: flex;
          position: fixed;
          align-items: center;
          justify-content: center;
         }
		 
	 h1 {
	  font-size: 40px;
          text-shadow: 4px 4px 30px rgba(150, 150, 150, 0.4);
         }
		
        p {
          font-size: 27px;
          text-shadow: 4px 4px 30px rgba(150, 150, 150, 0.4);
        }
		 
        i {
         text-shadow: 4px 4px 30px rgba(150, 150, 150, 0.4);
         }
         a{
         color : white;
         padding-left:10px;
         padding-right:5px;
         font-weight: bold;
         
         }
    </style> 
  </head>
<body>
<u:navbar/>
<%--
	<u:isLogin>
	${authUser.name }님, 안녕하세요.
    <a href="logout.do">[로그아웃하기]</a>
    <a href="changePwd.do">[암호변경하기]</a>
    <a href="removeMember.do">[회원 탈퇴하기]</a>
    <a href="article/list.do">[게시물 보기]</a>
	<a href="article/write.do">[게시물 쓰기]</a> 
	</u:isLogin>

    <u:notLogin>
      <a href="join.do">[회원가입하기]</a>
      <a href="login.do">[로그인하기]</a>
      <a href="findid.do">[아이디 찾기]</a>
     <a href="findpw.do">[비밀번호찾기]</a>
    </u:notLogin>
 --%>
 
  <body>


    <div class="container">
     <div class="animated zoomIn delay-0.1s">
	<h1>Geony First Project</h1>
	<p>완성은 다 못하였지만 최선을 다했습니다.</p>
	<u:notLogin>
		<a href="${root }/login.do"><i style="font-size: 2em; color: #ffff;" class="fas fa-sign-in-alt"></i>로그인</a>  &nbsp;
	</u:notLogin>
	<u:notLogin>
		<a href="${root }/join.do"><i style="font-size: 2em; color: #fff;" class="fas fa-user-plus"></i>회원가입</a>   &nbsp;
	</u:notLogin>
	<u:isLogin>
		<a href="${root }/logout.do"><i style="font-size: 2em; color: #ffff;" class="fas fa-sign-out-alt"></i>로그아웃</a>  &nbsp;
	</u:isLogin>
	<u:isLogin>
		<a href="${root }/article/write.do"><i style="font-size: 2em; color: #ffff;" class="fas fa-keyboard"></i>글 쓰기</a>  &nbsp;
	</u:isLogin>
		<a href="${root }/article/list.do"><i style="font-size: 2em; color: #ffff;" class="fas fa-align-justify"></i>글 목록</a> 
      </div>
     </div>
  </body>
</body>
</html>