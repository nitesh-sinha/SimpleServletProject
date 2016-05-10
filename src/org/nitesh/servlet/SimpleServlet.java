package org.nitesh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(urlPatterns = {"/SimpleServletPath"},
			initParams={@WebInitParam(name="defaultUserName", value="John Doe")})
// initParams can be specified in web.xml as well as <init-param></init-param>
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter respWriter = response.getWriter();
		String userName = request.getParameter("user");
		HttpSession session = request.getSession();
		if (userName != "" && userName != null) {
			session.setAttribute("savedUserName", userName);
		}
		
		respWriter.println(getServletName());
		respWriter.println(request.getContextPath());
		respWriter.print("User name passed in the request is " + userName);
		respWriter.println("\nSession has saved the user name " + (String)session.getAttribute("savedUserName"));
		
		String defaultUser = this.getServletConfig().getInitParameter("defaultUserName");
		respWriter.println("Init param has Default user = " + defaultUser);
	}

}
