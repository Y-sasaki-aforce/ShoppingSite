package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.UserBean;
import jp.co.aforce.dao.SqlDao;

@WebServlet("/jp.co.aforce.servlet/user-login")
public class UserLogin extends HttpServlet {
	 private static final long serialVersionUID = 1L;

	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public UserLogin() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	    /**
	     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("../views/regist.jsp");
	}
	/**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
		//ログイン認証
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ログイン画面で入力された値を取得
		String mail_address = request.getParameter("mail_address");
		String password = request.getParameter("password");
		String name = request.getParameter("name");

		 // user_login.jspから受け取ったログインIDとpasswordをbeanにセット
		UserBean bean = new UserBean();
		bean.setMail_address(mail_address);
		bean.setPassword(password);
		bean.setName(name);

		 // 検索したアカウント情報を取得
		SqlDao dao = new SqlDao();

		try {
			UserBean returnBean = dao.login(bean);

				if(returnBean != null) {
					HttpSession session=request.getSession();
					session.setAttribute("user", bean);
					session.setAttribute("user", returnBean);
					response.sendRedirect("../views/user_login_success.jsp");
				}else {
					request.setAttribute("error_msg", "IDまたはパスワードが違います。");
					request.getRequestDispatcher("../views/user_login.jsp").forward(request, response);
				}

		} catch (Exception e) {
			request.setAttribute("error_msg", "エラーが発生しました。");
			e.printStackTrace();
		}



	}

}