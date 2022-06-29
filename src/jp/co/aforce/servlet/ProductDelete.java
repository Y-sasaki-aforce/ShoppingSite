package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.SqlDao;
import jp.co.aforce.tool.Messages;

@WebServlet("/jp.co.aforce.servlet/product-delete")
public class ProductDelete extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("../views/product_regist.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int product_id=Integer.parseInt(request.getParameter("product_id"));

			SqlDao dao = new SqlDao();

			try {
				int line = dao.product_delete(product_id);

				if(line > 0) {
					request.setAttribute("msg", Messages.I_PRODUCT02);
					request.getRequestDispatcher("../views/product_edit.jsp").forward(request, response);
				}else {
					request.setAttribute("msg", Messages.E_PRODUCT04);
					request.getRequestDispatcher("../views/product_edit.jsp").forward(request, response);
				}
			} catch (Exception e) {
				request.setAttribute("msg", Messages.E_PRODUCT03);
				request.getRequestDispatcher("../views/product_edit.jsp").forward(request, response);
				e.printStackTrace();
			}
		}

}

