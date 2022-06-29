package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.UserBean;
import jp.co.aforce.dao.SqlDao;
import jp.co.aforce.tool.Messages;

@WebServlet("/jp.co.aforce.servlet/user-update")
public class UserUpdate extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("../views/user_login.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String name=request.getParameter("name");
		String mail_address=request.getParameter("mail_address");
		String address=request.getParameter("address");
		String password=request.getParameter("password");

			UserBean bean = new UserBean();
			bean.setName(name);
	        bean.setMail_address(mail_address);
	        bean.setAddress(address);
	        bean.setPassword(password);

			SqlDao dao = new SqlDao();

			try {
				int count = dao.update(bean);

				if(count > 0) {
					request.setAttribute("msg", Messages.I_USER03);
					response.sendRedirect("../views/user_login.jsp");
				}else {
					request.setAttribute("msg", Messages.E_USER05);
					request.getRequestDispatcher("../views/profile_edit.jsp").forward(request, response);
				}
			} catch (Exception e) {
				request.setAttribute("msg", Messages.E_USER03);
				request.getRequestDispatcher("../views/profile_edit.jsp").forward(request, response);
				e.printStackTrace();
			}
		}

}
