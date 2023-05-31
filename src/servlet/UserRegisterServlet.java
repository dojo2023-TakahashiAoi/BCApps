package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;
import model.User;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// アカウント登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String pw = request.getParameter("PW");
		String name = request.getParameter("NAME");

		String msg;

		// 登録処理を行う
		RegisterDAO rDao = new RegisterDAO();

		if (rDao.insert(new User(id, pw, name))) { // 登録成功
			// request.setAttribute("result", new Result("登録成功！", "レコードを登録しました。", "/simpleBC/MenuServlet"));
			System.out.println("登録が成功しました。");
			response.sendRedirect("/simpleBC/LoginServlet");
		}
		else { // 登録失敗
			// request.setAttribute("result", new Result("登録失敗！", "レコードを登録できませんでした。", "/simpleBC/MenuServlet"));
			System.out.println("登録が失敗しました。");
			msg = "登録が失敗しました。";
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('登録が失敗しました。');</script>");
//			request.setAttribute("message", msg);
//	        request.getRequestDispatcher("/WEB-INF/jsp/user_register.jsp").forward(request, response);
		}
		// ログインページにフォワードする
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
//		dispatcher.forward(request, response);

        // メッセージを設定し、登録ページに値を返す。
//        request.getRequestDispatcher("/WEB-INF/jsp/user_register.jsp").forward(request, response);
	}
}
