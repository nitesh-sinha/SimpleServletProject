package org.nitesh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6739511403459067318L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter wr = response.getWriter();
		// parameters are passed as part of the request URI
		// eg: http://localhost:8080/SimpleServletProject/xmlServletPath?user=nnnn&id=10
		String userName = request.getParameter("user");
		String id = request.getParameter("id");
		wr.println("Hello from GET method " + userName + id);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter wr = response.getWriter();
		// parameter is passed as part of the http post body
		// SimpleForm.html used as a POST form	
		String userName = request.getParameter("user");
		wr.println("Hello from POST method " + userName);
		String prof= request.getParameter("prof");
		String[] loc = request.getParameterValues("location");
		wr.println(". You are a " + prof + " from " + loc.length + " places, namely ");
		for(int i=0;i<loc.length;i++){
			wr.println(loc[i]);
		}
	}
}
