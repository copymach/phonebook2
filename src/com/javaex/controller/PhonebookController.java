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

		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> personList = phoneDao.getList();

		System.out.println(personList);

//		html과 list를 섞어서 표현해야한다.
//		servlet 으로는 표현이 복잡하다 -> 해결법 jsp를 이용.

		request.setAttribute("pList", personList);

//		  PrintWriter out = response.getWriter(); out.println("<head>");

//		포워드
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
		rd.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
