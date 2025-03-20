<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
<h3>게시물 등록</h3>
<form name="articleForm">
<input type="hidden" name="mid" value="${sessionScope.ss_mid}">
<table class="table table-hover">
	<tr>
		<td>게시판</td>
		<td class="text-start">
			<select name="bid" class="form-select d-inline-block w-auto"></select>
		</td>
	</tr>
	<tr>
		<td>제목</td>
		<td class="text-start"><input type="text" name="asubject" class="form-control d-inline-block w-60"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td class="text-start"><textarea rows="10" cols="120" name="acontent" class="form-control d-inline-block w-auto"></textarea></td>
	</tr>
	<tr>
		<td>파일</td>
		<td class="text-start">
			<input type="file" id="fileInput" multiple  class="form-control d-inline-block w-60">
		</td>
	</tr>
</table>
<p class="text-end">
	<input type="button" value="등록" onclick="javascript:article.insertArticle();" class="btn btn-primary">&nbsp;
	<input type="button" value="목록" onclick="location.href='/article/articles';" class="btn btn-success">
</p>
</form>
<script>
$(function() {
	board.getBoardList();
});
</script>
<%@ include file="/jsp/include/footer.jsp" %>