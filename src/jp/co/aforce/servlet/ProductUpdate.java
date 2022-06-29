package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.ProductBean;
import jp.co.aforce.dao.SqlDao;
import jp.co.aforce.tool.Messages;

@WebServlet("/jp.co.aforce.servlet/product-update")
public class ProductUpdate extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("../views/product_regist.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String product_name=request.getParameter("product_name");
		int product_price=Integer.parseInt(request.getParameter("product_price"));
		int product_id=Integer.parseInt(request.getParameter("product_id"));

			ProductBean bean = new ProductBean();
			bean.setProduct_name(product_name);
	        bean.setProduct_price(product_price);
	        bean.setProduct_id(product_id);

			SqlDao dao = new SqlDao();

			try {
				int count = dao.product_update(bean);

				if(count > 0) {
					request.setAttribute("msg", Messages.I_PRODUCT03);
					request.getRequestDispatcher("../views/product_edit.jsp").forward(request, response);
				}else {
					request.setAttribute("msg", Messages.E_PRODUCT05);
					request.getRequestDispatcher("../views/product_edit.jsp").forward(request, response);
				}
			} catch (Exception e) {
				request.setAttribute("msg", Messages.E_PRODUCT03);
				request.getRequestDispatcher("../views/product_edit.jsp").forward(request, response);
				e.printStackTrace();
			}
		}

}
