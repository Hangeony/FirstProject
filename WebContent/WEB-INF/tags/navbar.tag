<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="${root }/index.jsp"><i class="fab fa-google"></i></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class=" navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
    <u:isLogin>
      <li class="nav-item active" style="padding : 8px; color : black;">
        ${authUser.name }님 안녕하세요.
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${root }/changePwd.do">비밀	번호 변경</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="${root }/removeMember.do">회원 탈퇴</a>
      </li>
    </u:isLogin>
    
    <u:notLogin>
    <%--
    <li class="nav-item">
      <a class="nav-link" href="${root }/join.do">회원가입</a>
     </li>
     --%>
    <li class="nav-item">
        <a class="nav-link" href="${root }/findid.do">아이디 찾기</a>
      </li>
    <li class="nav-item">
        <a class="nav-link" href="${root }/findpw.do">비밀번호 찾기</a>
      </li>
     </u:notLogin>
      
      <li class="nav-item">
        <a class="nav-link" href="${root }/article/list.do">글목록</a>
      </li>
    </ul>
    
    <u:notLogin>
    <span class="navbar-text">
     <a href="${root }/login.do">로그인</a>
    </span>
    </u:notLogin>
    
    <u:isLogin>
    <span class="navbar-text">
     <a href="${root }/logout.do">로그아웃</a>
    </span>
    </u:isLogin>
  </div>
</nav>