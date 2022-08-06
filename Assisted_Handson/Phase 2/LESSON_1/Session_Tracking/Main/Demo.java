package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Demo
 */
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    int count;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		HttpSession hs = request.getSession();
		pw.println("<br> session Id" +hs.getId());
		if(hs.isNew()) {
			pw.println("<br/> New Client");
		}else {
			pw.println("<br> Old Client");
		}
		pw.println("<br> Session Creation Time" +hs.getCreationTime());
		pw.println("<br> Session Creation Time" +new Date(hs.getCreationTime()));
		pw.println("<br> Session Last Access Time" +new Date(hs.getLastAccessedTime()));
		pw.println("<br> Session Default Time" +hs.getMaxInactiveInterval());
		hs.setMaxInactiveInterval(600);
		pw.println("<br> Session Change Default Time" +hs.getMaxInactiveInterval());
		count++;
		if(count%5==0) {
			hs.invalidate();
		}
		pw.println("<br/> Count Value" +count);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
