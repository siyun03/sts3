<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
<h3>게시물 목록</h3>
<form name="articleSearchForm" action="/article/articles">
	총게시물 수 : ${articleCriteria.totalRowCount}&nbsp;&nbsp;
	<input type="hidden" name="pageNum" />
	<input type="hidden" name="pageSize" />
	<select name="bid" class="form-select d-inline-block w-auto">
		<option value="" <c:if test="${empty articleCriteria.bid}">selected</c:if>>전체</option>
	</select>&nbsp;
	<select name="searchClass" class="form-select d-inline-block w-auto">
		<option value="" <c:if test="${empty articleCriteria.searchClass}">selected</c:if>>전체</option>
		<option value="asubject" <c:if test="${articleCriteria.searchClass=='asubject'}">selected</c:if>>제목</option>
		<option value="acontent" <c:if test="${articleCriteria.searchClass=='acontent'}">selected</c:if>>내용</option>
		<option value="mid" <c:if test="${articleCriteria.searchClass=='mid'}">selected</c:if>>작성자아이디</option>
	</select>&nbsp;
	<input type="text" name="searchVal" value="${articleCriteria.searchVal}" class="form-control d-inline-block w-auto">&nbsp;
	<input type="button" value="검색" 
		onclick="javascript:article.selectArticle('1', '${articleCriteria.pageSize}');" 
		class="btn btn-success">		
</form>
<c:if test="${!empty ss_mid}">
<p class="text-end">
	<input type="button" value="등록" onclick="location.href='/article/insertArticleForm';" class="btn btn-primary">
</p>
</c:if>
<table class="table table-hover">
	<thead>
		<tr>
			<th>아이디</th>
			<th>게시판</th>
			<th>제목</th>
			<th>조회수</th>
			<th>작성자</th>
			<th>등록일시</th>
			<th>첨부파일수</th>
		</tr>
	</thead>
	<c:if test="${!empty articleList}">
	<tbody>
		<c:forEach var="article" items="${articleList}">
		<tr>
			<td>${article.aid}</td>
			<td>${article.bname}</td>
			<td class="text-start"><a href="/article/articles/${article.aid}">${article.asubject}</a></td>
			<td>${article.avcnt}</td>
			<td>${article.mid}</td>
			<td><fmt:formatDate value="${article.aregdate}" pattern="M/dd HH:mm" /></td>
			<td>${article.aafcnt}</td>
		</tr>
		</c:forEach>
	</tbody>
	</c:if>
</table>

<ul class="pagination">
    <c:if test="${articleCriteria.pageNum > 1}">
        <li class="page-item">
            <a class="page-link" 
            href="javascript:article.selectArticle('${articleCriteria.pageNum-1}', '${articleCriteria.pageSize}');">이전</a>
        </li>
    </c:if>
    <c:forEach var="i" begin="1" end="${articleCriteria.totalPageCount}">
        <li class="page-item ${i == articleCriteria.pageNum ? 'active' : ''}">
            <a class="page-link" 
            href="javascript:article.selectArticle('${i}', '${articleCriteria.pageSize}');">${i}</a>
        </li>
    </c:forEach>
    <c:if test="${articleCriteria.pageNum < articleCriteria.totalPageCount}">
        <li class="page-item">
            <a class="page-link" 
            href="javascript:article.selectArticle('${articleCriteria.pageNum+1}', '${articleCriteria.pageSize}');">다음</a>
        </li>
    </c:if>
</ul>

<script>
$(function() {
	board.getBoardList("${articleCriteria.bid}");
});
</script>
<%@ include file="/jsp/include/footer.jsp" %>










