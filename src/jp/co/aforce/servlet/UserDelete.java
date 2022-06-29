package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.SqlDao;
import jp.co.aforce.tool.Messages;

@WebServlet("/jp.co.aforce.servlet/user-delete")
public class UserDelete extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("../views/home.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String password=request.getParameter("password");

			SqlDao dao = new SqlDao();

			try {
				int line = dao.delete(password);

				if(line > 0) {
					request.setAttribute("msg", Messages.I_USER02);
					response.sendRedirect("../views/user_delete_complete.jsp");
				}else {
					request.setAttribute("msg", Messages.E_USER04);
					response.sendRedirect("../views/profile.jsp");
				}
			} catch (Exception e) {
				request.setAttribute("msg", Messages.E_USER03);
				request.getRequestDispatcher("../views/profile.jsp").forward(request, response);
				e.printStackTrace();
			}
		}

}
