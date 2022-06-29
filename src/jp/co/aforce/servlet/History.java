package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.ProductBean;
import jp.co.aforce.dao.SqlDao;

@WebServlet("/jp.co.aforce.servlet/history")
public class History extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("../views/home.jsp");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

			HttpSession session = request.getSession();
			try {

			ProductBean bean = new ProductBean();
			SqlDao dao=new SqlDao();
			List<ProductBean> list= dao.purchase_list(bean);

			session.setAttribute("product_list", list);

			request.getRequestDispatcher("../views/history.jsp").forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}



	}
}
