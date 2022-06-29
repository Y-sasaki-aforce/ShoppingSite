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

@WebServlet("/jp.co.aforce.servlet/product-regist")
public class ProductRegist extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("../views/product_edit.jsp");
	}

	public void doPost(
		//リクエストを取得するために使う引数、レスポンスを生成するために使う引数
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		try {
			String product_name=request.getParameter("product_name");
			int product_price=Integer.parseInt(request.getParameter("product_price"));

			// product_regist.jspから受け取った値をbeanにセット
			ProductBean bean = new ProductBean();
			bean.setProduct_name(product_name);
	        bean.setProduct_price(product_price);

	        SqlDao dao = new SqlDao();
			int count = dao.product_search(bean);

			if(count >= 1) {
				request.setAttribute("msg", Messages.E_PRODUCT01);
				request.getRequestDispatcher("../views/product_regist.jsp").forward(request, response);
			} else if(count == 0){
				dao.product_insert(bean);
				request.setAttribute("msg", Messages.I_PRODUCT01);
				request.getRequestDispatcher("../views/product_regist.jsp").forward(request, response);
			}
		}catch (Exception e) {
			request.setAttribute("msg", Messages.E_PRODUCT02);
			request.getRequestDispatcher("../views/product_regist.jsp").forward(request, response);
			e.printStackTrace();
		}

	}
}
