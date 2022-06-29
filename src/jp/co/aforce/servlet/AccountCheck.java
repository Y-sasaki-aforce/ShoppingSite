package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.UserBean;

@WebServlet("/jp.co.aforce.servlet/account-check")
public class AccountCheck extends HttpServlet{
	private static final long serialVersionUID = 1L;
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public AccountCheck() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	    /**
	     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // TODO Auto-generated method stub

	        // セッションからログイン情報を取得
	        HttpSession session = request.getSession();
	        UserBean bean = (UserBean) session.getAttribute("user");

	        // 会員番号でフォワード先を振り分ける
	        if(bean.getMember_id() == 1) {
	        	response.sendRedirect("../views/product_regist.jsp");
	        } else {
	        	response.sendRedirect("../views/home.jsp");
	        }

	        System.out.println(bean.getMember_id());
	    }

	    /**
	     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // TODO Auto-generated method stub
	        doGet(request, response);
	    }
	}
