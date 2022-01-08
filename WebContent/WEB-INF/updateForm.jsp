<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="com.javaex.vo.PersonVo"%>
    <%@ page import="java.util.List"%>
    
    <%
    int personId = Integer.parseInt(request.getParameter("id"));

    int id = PersonVo.getPersonId();
    String name = PersonVo.getName();
    String hp = PersonVo.getHp();
    String company = PersonVo.getCompany();
    
    List<PersonVo> personList = (List<PersonVo>) request.getAttribute("pList");
  
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>[Phonebook1]</h1>
	<h2>전화번호 수정폼</h2>
	<p>전화번호를 수정하려면 아래 항목을 기입하고 등록 버튼을 누르세요</p>
	<!-- id를 form에 넣지 않았더니 update.jsp에 전달이 안되서 에러 -->
	<form action="./update.jsp" method="get">
		이름(name) : <input type="text" name="name" value="<%=name%>"> 
		<br> 
		핸드폰(hp) : <input	type="text" name="hp" value="<%=hp%>"> 
		<br>
		회사(company) <input type="text" name="company" value="<%=company%>"> 
		<br> 
		저장ID <input type="text" name="id" value="<%=id%>"> 
		<br> 
		<button type="submit">수정</button>
	</form>
	<a href="http://localhost:8088/phonebook1/list.jsp">목록으로 (절대경로)</a>
	<a href="./list.jsp">목록으로 돌아가기</a>
</body>
</html>