package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.UserBean;
import jp.co.aforce.dao.SqlDao;
import jp.co.aforce.tool.Messages;

@WebServlet("/jp.co.aforce.servlet/user-regist")
public class UserRegist extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("../views/user_login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");


		try {

			String name = request.getParameter("name");
			String mail_address = request.getParameter("mail_address");
			String address = request.getParameter("address");
			String password = request.getParameter("password");

			SqlDao dao = new SqlDao();
			UserBean bean = new UserBean(name,mail_address,address,password);

			int count = dao.search(bean);

			if(count >= 1) {
				request.setAttribute("msg", Messages.E_USER01);
				request.getRequestDispatcher("../views/regist.jsp").forward(request, response);
			} else if(count == 0) {
				dao.insert(bean);
				HttpSession session = request.getSession();
		        session.setAttribute("user", bean);
				request.setAttribute("msg", Messages.I_USER01);
				request.getRequestDispatcher("../views/regist.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", Messages.E_USER02);
			request.getRequestDispatcher("../views/regist.jsp").forward(request, response);
			}
		}
}
