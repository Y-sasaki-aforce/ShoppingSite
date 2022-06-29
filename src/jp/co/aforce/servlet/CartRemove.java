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

@WebServlet("/jp.co.aforce.servlet/cart-remove")
public class CartRemove extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("../views/home.jsp");
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

			HttpSession session = request.getSession();

			//カートに追加する商品を取得
			int product_id = Integer.parseInt(request.getParameter("id"));

			try {
				//nullを取得すればカートを生成
				List<ItemBean> cart=(List<ItemBean>)session.getAttribute("cart");

				//カート内に追加する商品が存在するかチェック
				for (ItemBean i : cart) {
					if (i.getProduct().getProduct_id() == product_id) {
						cart.remove(i);
						break;
					}
				}

				request.getRequestDispatcher("../views/purchase_in.jsp").forward(request, response);

			} catch (Exception e) {
				request.getRequestDispatcher("../views/purchase_in.jsp").forward(request, response);
				e.printStackTrace();
			}



	}
}
