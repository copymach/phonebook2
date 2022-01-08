package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@WebServlet("/pbc") // PhonebookController
public class PhonebookController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("PhonebookController");

		String act = request.getParameter("action");

//		System.out.println(act);

//		case 로 쓰면 좋지만 변수 안먹는 경우가 있어서 if문으로 만든다

		if ("list".equals(act)) {
			System.out.println("act=list");

			PhoneDao phoneDao = new PhoneDao();
			List<PersonVo> personList = phoneDao.getList();

//			html과 list를 섞어서 표현해야한다.
//			servlet 으로는 표현이 복잡하다 -> 해결법 jsp를 이용.

			request.setAttribute("pList", personList);
//			PrintWriter out = response.getWriter(); out.println("<head>");

//			포워드
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
			rd.forward(request, response);

			System.out.println(personList);

		} else if ("writeForm".equals(act)) {
			System.out.println("act=writeForm");

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/writeForm.jsp");
			rd.forward(request, response);

		} else if ("write".equals(act)) {
			System.out.println("action=write");

//			파라미터 3개를 꺼내온다
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");

//			vo로 만든다
			PersonVo personVo = new PersonVo(name, hp, company);
			System.out.println(personVo);

//			dao 메모리 올린다
			PhoneDao phoneDao = new PhoneDao();

//			dao.insert(vo);
			phoneDao.ContactsInput(personVo);

//			리다이렉트 (지금 상황에서 포워드보다 낫다)
			response.sendRedirect("/phonebook2/pbc?action=list");
			
		} else if ("insert".equals(act)) {
			System.out.println("action=insert");
			
		} else if ("delete".equals(act)) {
			System.out.println("delete");
			
		} else if ("updateForm".equals(act)) {
			System.out.println("updateForm");
			
		} else {
			System.out.println("파라미터 값 없음");
			
		} // if 문 종료

	} // doGet 종료

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

} // PhonebookController 종료
