<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
<h3>게시판목록</h3>
<c:if test="${!empty ss_mid}">
<p class="text-end">
	<input id="insertBtn" type="button" value="등록" onclick="location.href='/board/insertBoardForm';" class="btn btn-primary">
</p>
</c:if>
<table class="table table-hover">
	<thead>
		<tr>
			<th>아이디</th>
			<th>게시판명</th>
			<th>게시물수</th>
			<c:if test="${!empty ss_mid}">
			<th>수정</th>
			</c:if>
		</tr>
	</thead>
	<c:if test="${!empty boardList}">
	<tbody>
		<c:forEach var="board" items="${boardList}">
		<tr>
			<td>${board.bid}</td>
			<td>${board.bname}</td>
			<td>${board.bacnt}</td>
			<c:if test="${!empty ss_mid}">
			<td>
				<input type="button" value="수정" onclick="location.href='/board/updateBoardForm/${board.bid}';" class="btn btn-warning">&nbsp;
			</td>
			</c:if>
		</tr>
		</c:forEach>
	</tbody>
	</c:if>
</table>
<%@ include file="/jsp/include/footer.jsp" %>