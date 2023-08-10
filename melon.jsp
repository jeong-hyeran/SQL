<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>melon.jsp</title>
</head>
<body>

<jsp:useBean id="dao" class="melon.DAO" />
<c:set var="list" value="${dao.selectList() }" />

<table>
	<thead>
		<tr>
			<th>순위</th>
			<th>제목</th>
			<th>가수</th>
			<th>앨범</th>
			<th>좋아요</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="line" items="${list }">
		<tr>
			<td>${line.ranking }</td>
			<td>${line.title }</td>
			<td>${line.artist }</td>
			<td>${line.album }</td>
			<td>${line.likeCount }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

</body>
</html>