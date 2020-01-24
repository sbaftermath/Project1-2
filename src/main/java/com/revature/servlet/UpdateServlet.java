package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pojo.Superhuman;
import com.revature.service.SuperhumanService;
import com.revature.service.SuperhumanServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static SuperhumanService ss = new SuperhumanServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Superhuman sh = new Superhuman();
		
		sh.setSuperhumanName(request.getParameter("superhuman_name"));
		sh.setPowers(request.getParameter("superhuman_powers"));
		sh.setWeakness(request.getParameter("superhuman_weakness"));
		sh.setAlignment(request.getParameter("superhuman_alignment"));
		
		ss.updateSuperhuman(sh);
		
		response.sendRedirect("http://localhost:8080/Project1/");
		
	}

}
