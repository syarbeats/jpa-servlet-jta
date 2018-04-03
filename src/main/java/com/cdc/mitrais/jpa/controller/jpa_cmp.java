package com.cdc.mitrais.jpa.controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdc.mitrais.jpa.dao.GeekDAO;
import com.cdc.mitrais.jpa.entity.Geek;


/**
 * Servlet implementation class jpa_cmp
 */
public class jpa_cmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(jpa_cmp.class);
	private GeekDAO geekDAO = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public jpa_cmp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		geekDAO = new GeekDAO();
		
		try {
			
			List<Geek> geekList = geekDAO.getAllGeek();
			
			for(Geek geek : geekList) {
				logger.info("Geek Data: Name:"+geek.getFirstName()+" "+geek.getLastName());
			}

			@SuppressWarnings("unused")
			HttpSession session = request.getSession();
			request.setAttribute("geekList", geekList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/display-person.jsp");
			dispatcher.forward(request, response);

		}finally {			
			geekDAO.closeEntityManager();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
