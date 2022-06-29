package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.util.StringUtils;

import jp.co.aforce.bean.ItemBean;
import jp.co.aforce.dao.SqlDao;

@WebServlet("/jp.co.aforce.servlet/purchase-action")
public class PurchaseAction extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("../views/home.jsp");
	}


	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

			HttpSession session = request.getSession();

			String customer_payment = request.getParameter("payment");

			if  (StringUtils.isNullOrEmpty(customer_payment)) {
				response.sendRedirect("../views/purchase_error_empty.jsp");
			}

			try {
				SqlDao dao = new SqlDao();

				List<ItemBean> cart=(List<ItemBean>)session.getAttribute("cart");
				if(cart == null || !dao.purchase_insert(cart, customer_payment)) {
					response.sendRedirect("../views/purchase_error_insert.jsp");
				}else {
					session.removeAttribute("cart");
					response.sendRedirect("../views/purchase_complete.jsp");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}



	}
}