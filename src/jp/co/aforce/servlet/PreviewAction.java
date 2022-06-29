package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.ItemBean;

@WebServlet("/jp.co.aforce.servlet/preview-action")
public class PreviewAction extends HttpServlet{


	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

			HttpSession session = request.getSession();

			try {
				//カートが存在しなければフォワードする
				List<ItemBean> cart=(List<ItemBean>)session.getAttribute("cart");
				if(cart == null || cart.size()==0) {
					response.sendRedirect("../views/cart_null.jsp");
					session.setAttribute("cart", cart);
				}

				response.sendRedirect("../views/purchase_in.jsp");


			} catch (Exception e) {
				e.printStackTrace();
			}



	}
}
