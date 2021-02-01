<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta charset="UTF-8">
<style>
.col{
text-align: center;
}
.pagination{
font-color : green;
}
</style>
<title>Insert title here</title>
</head>
<body>
<u:navbar/>
<div class="container">
	<div class="table-responsive">
	<table class="table table-sm" style="table-layout: inherit;">
  <thead style="text-align: center;">
    <tr >
      <th  scope="col"></th>
      <th  style="text-align: center;" scope="col">제목</th>
      <th  style="text-align: center;" scope="col">작성자</th>
      <th  style="text-align: center;" scope="col">조회수</th>      
    </tr>
  </thead>
  <tbody>
  <c:if test="${articlePage.hasNoArticles() }">
		<tr>
			<td colspan="4">게시글이 없습니다.</td>
		</tr>
	</c:if>
  <c:forEach var="article" items="${articlePage.content }">
    <tr>
      <th scope="row"></th>
      <td>
      <a href="read.do?no=${article.number }&pageNo=${articlePage.currentPage}">
	  <c:out value="${article.title}" ></c:out>[<c:out value="${article.comment_count }"></c:out>]
	  </a>
	  </td>
      <td style="text-align: center;">${article.writer.name }</td>
      <td style="text-align: center;">${article.readCount} </td>
    </tr>
	</c:forEach>
  </tbody>
</table>
</div>
	<div class="row justify-content-end pl-3 pr-3 pt-1 pb-1">
		<div class="post_btns">
			<div class="fr">
				<button type="button" class="btn btn-success" id="write-submit-btn"data-path="${root}/article/write.do">글 쓰기</button>
			</div>
		</div>
	</div>
<div class="mt-5 pagenation-container d-flex justify-content-center">
<c:if test="${articlePage.hasArticles() }">
	 <nav aria-label="Page navigation example">
            <ul class="pagination">
              <c:if test="${articlePage.startPage > 5}">
                <li class="page-item"><a class="page-link" href="${root }/article/list.do?pageNo=${articlePage.startPage - 5 }">Previous</a></li>
              </c:if>      
              <c:forEach begin="${articlePage.startPage }" end="${articlePage.endPage }" var="pNo">
                <li class="page-item"><a class="page-link" href="${root }/article/list.do?pageNo=${pNo}">${pNo }</a></li>
              </c:forEach>
              <c:if test="${articlePage.endPage < articlePage.totalPages }">
                <li class="page-item"><a class="page-link" href="${root }/article/list.do?pageNo=${articlePage.startPage + 5 }">Next</a></li>
              </c:if>
            </ul>
          </nav>
</c:if>
</div>
<nav class="navbar navbar-default">
        <div class="nav nav-justified navbar-nav">
             <form class="navbar-form navbar-search mx-auto" role="search" action="list.do" method="post">
                <div class="input-group">
                <select name="searchType" class="form-control">
						<option ${(param.searchType == "title")? "selected" : ""} value="title">제목</option>
						<option ${(param.searchType == "writer_id")? "selected" : ""}value="writer_id">작성자</option>
					</select> 
                   <input type="text" class="form-control" name="keyword" value="${param.keyword}">
                          <div class="input-group-append">
                        <button type="submit" class="btn btn-success">
                            <span class="glyphicon glyphicon-search"></span>
                            <span class="label-icon">검색</span>
                        </button>
                    </div>
                </div>  
            </form>          
        </div>
    </nav>
</div>

<script>
 $('#write-submit-btn').off().on('click', function(event) {
	 var path = event.currentTarget.dataset.path;
	 console.log(path);
	  location.href = path;
 });
</script>

</body>
</html>