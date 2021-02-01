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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<u:navbar/>
 ${authUser.name }님 회원탈퇴에 실패하셨습니다. <br />
 비밀번호 혹은 아이디를 다시한번 확인해주세요. <br />
 <a href="removeMember.do">[회원 탈퇴하기]</a>
 <a href="findpw">[비밀번호찾기]</a>
 <a href="index.jsp">[메인화면으로 돌아가기]</a>
 
</body>
</html>