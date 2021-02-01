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
<link rel="stylesheet" type="text/css" href="css/join.css" />
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<u:navbar />
	<%--
<div class="container">
<h1>회원가입</h1>
<form action="join.do" method="post">
<p>
아이디 <br /> <input type="text" name="id" value="${param.id }"/>

<c:if test="${errors.id }">ID를 입력하시오</c:if>
<c:if test="${errors.duplicateId }">이미 사용중인 아이디입니다.</c:if>
</p>
<p>
비밀번호 <br /> <input type="password" name="password"/>
<c:if test="${errors.password }">암호를 입력하시오.</c:if>
</p>
<p>
비밀번호 재확인 <br /> <input type="password" name="confirmPassword" />
<c:if test="${errors.confirmPassword }">암호를 입력하세요</c:if>
<c:if test="${errors.notMatch }">암호가 일치 하지 않습니다.</c:if>
</p>
<p>
이름 <br /> <input type="text" name="name" value="${param.name }" />
<c:if test="${errors.name }">이름을 입력하세요</c:if>
</p>
<p>
생일 <br /> <input type="text" name="birth" value="${param.birth }" />
<c:if test="${errors.birth }">생일을 입력하시오</c:if>
</p>

<p>
<input type="radio" name="gender" value="남자">남자
<input type="radio" name="gender" value="여자">여자<br>
</p>

<p>
번호 <br /> 
<input type="text" name="cellphone" value="${param.cellphone }" />
<c:if test="${errors.cellphone }">폰 번호를 입력하세요</c:if>
</p>
<input type="submit" value="회원가입" />
</form>

</div>
 --%>
	<div class="positioner">
		<div class="shadowebox w-100">
			<div class="logowrapper">
				<a class="navbar-brand1" href="${root }/index.jsp">
				<i class="fab fa-google"></i></a>
			</div>
			<div class="contents">
				<h2 class="title">회원가입</h2>
				<form onsubmit="return checkz()" method="post" id="theForm" action="${root }/join.do">
					<table style="width: 100%;">
						<tbody class="table">
							<tr class="row">
								<td class="label">아이디</td>
								<td>
								<input class="Input" type="text" id="tbID" name="id" placeholder="아이디" value="${param.id }" />
								<small>
								<c:if test="${errors.id }">ID를 입력하시오</c:if>
								<c:if test="${errors.duplicateId }">이미 사용중인 아이디입니다.</c:if>
								</small>
								</td>
							</tr>
							<tr class="row">
								<td class="label">패스워드(6-8 글자)</td>
								<td>
									<input class="Input" type="password" id="tbPwd"	name="password" placeholder="비밀번호" name="password" />
								<small>
									<c:if test="${errors.password }">암호를 입력하시오.</c:if>
								</small>
								</td>
							</tr>
							<tr class="row">
								<td class="label">비밀번호 재확인</td>
								<td>
								<input class="Input" type="password" id="cpass"	name="confirmPassword" placeholder="비밀번호 재확인" />
								<small>
									<c:if test="${errors.confirmPassword }">암호를 입력하세요</c:if>
									<c:if test="${errors.notMatch }">암호가 일치 하지 않습니다.</c:if>
								</small>
								</td>
							</tr>
							<tr class="row">
								<td class="label">이름</td>
								<td>
								<input class="Input" type="text" id="name" name="name" placeholder="이름" value="${param.name }"/>
								<small>
								<c:if test="${errors.name }">이름을 입력하세요</c:if>
								</small>
								</td>
							</tr>
							<tr class="row">
								<td class="label">생년월일</td>
								<td>
								<input type="text" name="yyyy" id="yy" placeholder="년(4자)" aria-label="년(4자)" class="int" maxlength="4">
								<select name="mm" id="mm" class="sel" aria-label="월">
									<option value="월">월</option>
									<option value="01">1</option>
									<option value="02">2</option>
									<option value="03">3</option>
									<option value="04">4</option>
									<option value="05">5</option>
									<option value="06">6</option>
									<option value="07">7</option>
									<option value="08">8</option>
									<option value="09">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
								</select>
								<input type="text" name="dd" id="dd" placeholder="일" aria-label="일" class="int" maxlength="2">
								<small>
								<%--  <c:if test="${errors.birth }">생일을 입력하시오</c:if> --%>
								</small>
								</td>
							</tr>
							<tr class="row">
								<td class="label">성별</td>
								<td class="checkbox-wrapper">
								<input type="radio" name="gender" value="남자" id="m" />
								 <label for="m">남자</label>
								<input type="radio" name="gender" value="여자" id="f" /> 
								<label for="f">여자</label></td>
							</tr>
							<tr class="row">
								<td class="label">휴대폰 번호</td>
								<td>
								<input class="input" type="text" id="phone" name="cellphone1" maxlength="3" /> -
								<input class="input" type="text" name="cellphone2" maxlength="4"/> - 
								<input class="input" type="text" name="cellphone3" maxlength="4"/>
								<small>
								<c:if test="${errors.cellphone1 }">폰 번호를 입력하세요</c:if>
								</small>
								</td>
							</tr>
							<tr class="row">
								<td>
								<input class="submit" type="submit" value="회원가입" id="submit" />&nbsp;</td>
								<td class="wrapper">
								<a class="reset" style="text-decoration: none" class="lg_local_btn" href="${root }/index.jsp" role="button">첫 페이지로</a> 
								<input class="reset" type="reset" value="다시입력" id="reset" /></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>