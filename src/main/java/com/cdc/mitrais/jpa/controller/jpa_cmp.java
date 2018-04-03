package com.cdc.mitrais.jpa.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdc.mitrais.jpa.entity.Geek;
import com.cdc.mitrais.jpa.listener.PersonListener;

/**
 * Servlet implementation class jpa_cmp
 */
public class jpa_cmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(jpa_cmp.class);

	EntityManager entityManager = null;

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
		entityManager = PersonListener.createEntityManager() ;
		try {

			@SuppressWarnings("unchecked")
			List<Geek> geekList = entityManager.createQuery("Select e FROM Geek e").getResultList();

			for(Geek geek : geekList) {
				logger.info("Geek Data: Name:"+geek.getFirstName()+" "+geek.getLastName());
			}

			@SuppressWarnings("unused")
			HttpSession session = request.getSession();
			request.setAttribute("geekList", geekList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/display-person.jsp");
			dispatcher.forward(request, response);

		}finally {
			entityManager.close();
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
