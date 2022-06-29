package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jp.co.aforce.servlet/product-check")
public class ProductCheck extends HttpServlet{
	private static final long serialVersionUID = 1L;
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public ProductCheck() {
	        super();
	    }

	    /**
	     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // セッションからログイン情報を取得
	        //HttpSession session = request.getSession();
	       //ProductBean bean = (ProductBean) session.getAttribute("product");
		       int product_id = Integer.parseInt(request.getParameter("id"));

		        // 商品番号で遷移先を振り分ける
		        if(product_id == 1) {
		        	response.sendRedirect("../views/item1.jsp");
		        } else if(product_id == 2) {
		        	response.sendRedirect("../views/item2.jsp");
		        }else if(product_id == 3) {
		        	response.sendRedirect("../views/item3.jsp");
		        }else if(product_id == 4) {
		        	response.sendRedirect("../views/item4.jsp");
		        }else if(product_id == 5) {
		        	response.sendRedirect("../views/item5.jsp");
		        }else if(product_id == 6) {
		        	response.sendRedirect("../views/item6.jsp");
		        }else if(product_id == 7) {
		        	response.sendRedirect("../views/item7.jsp");
		        }else if(product_id == 8) {
		        	response.sendRedirect("../views/item8.jsp");
		        }

	    }

	    /**
	     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }
	}
