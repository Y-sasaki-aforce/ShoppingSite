package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.ItemBean;
import jp.co.aforce.bean.ProductBean;
import jp.co.aforce.tool.Messages;

@WebServlet("/jp.co.aforce.servlet/cart-add")
public class CartAdd extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("../views/product_info.jsp");
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
				if(cart == null) {
					cart = new ArrayList<ItemBean>();
					session.setAttribute("cart", cart);
				}

				//カート内に追加する商品が存在するかチェック
				for (ItemBean i : cart) {
					if (i.getProduct().getProduct_id() == product_id) {
						i.setCount(i.getCount()+1);
						request.getRequestDispatcher("../views/product_info.jsp").forward(request, response);
					}
				}

				//カート内に追加する商品が存在しないとき
				List<ProductBean> list=(List<ProductBean>)session.getAttribute("product_list");
				for (ProductBean p : list) {
					if (p.getProduct_id() == product_id) {
						ItemBean i =new ItemBean();
						i.setProduct(p);
						i.setCount(1);
						//カートにItemBeanを追加
						cart.add(i);
					}
				}
				request.setAttribute("msg", Messages.I_CART01);
				request.getRequestDispatcher("../views/product_info.jsp").forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}



	}
}
