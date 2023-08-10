<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movie.jsp</title>
</head>
<body>
<jsp:useBean id="dao" class="movie.MovieDAO" />
<c:set var="dto" value="${dao.selectList() }" />
<table>
<thead>
	<tr>
		<th>순위</th>
		<th>제목</th>
		<th>개봉일</th>
		<th>예매율</th>
		<th>예매수</th>
		<th>관객수</th>
	</tr>
</thead>
<tbody>
<c:forEach var="list" items="${dto }" >
	<tr>
		<td>${list.movie_rank }</td>
		<td>${list.title }</td>
		<td>${list.openningdate }</td>
		<td>${list.reserveRate }</td>
		<td>${list.reserveCount }</td>
		<td>${list.watchCount }</td>
	</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>