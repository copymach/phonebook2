<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.javaex.vo.PersonVo"%>

<%
//dao에서 가져온게 아님
List<PersonVo> personList = (List<PersonVo>) request.getAttribute("pList");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호 리스트 [phonebook2]</h1>

	<P>
		<a href="http://localhost:8088/phonebook2/pbc?action=writeForm">연락처 추가하기(절대경로)</a>
		<br>
		<a href="/phonebook2/pbc?action=writeForm">연락처 추가하기(상대경로)</a>
	</p>
	<p>model2 방식으로 만든 전화번호부</p>
	<p>입력한 정보 내역입니다.</p>
	<p>최근에 입력한 순서대로 보여줍니다.</p>
	
	<%
	for (int i = 0; i < personList.size(); i++) {
	%>
	<table border="1">
		<tr>
			<td>이름(name)</td>
			<td><%=personList.get(i).getName()%></td>
		</tr>
		<tr>
			<td>핸드폰(Hp)</td>
			<td><%=personList.get(i).getHp()%></td>
		</tr>
		<tr>
			<td>회사(Company)</td>
			<td><%=personList.get(i).getCompany()%></td>
		</tr>
		<tr>
			<td><a href=./updateForm.jsp?id=<%=personList.get(i).getPersonId()%>>수정</a></td>
			<td><a href=./delete.jsp?id=<%=personList.get(i).getPersonId()%>>삭제</a></td>
		</tr>
	</table>
	<br>
	<%
	}
	%>
	<br>
<a href="http://localhost:8088/phonebook1/writeForm.jsp">전화번호 추가하기</a>

</body>
</html>