package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BcDAO;
import model.Bc;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}

		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("NAME");
		String company = request.getParameter("COMPANY");
		String department = request.getParameter("DEPARTMENT");
		String position = request.getParameter("POSITION");
		String address = request.getParameter("ADDRESS");
		String email = request.getParameter("EMAIL");
		String phone_number = request.getParameter("PHONE_NUMBER");
		String post_code = request.getParameter("POST_CODE");
		String memo = request.getParameter("MEMO");

		// ログインされているユーザのIDを取得
		String id = (String)session.getAttribute("id");

		// 登録処理を行う
		BcDAO bDao = new BcDAO();
		if (bDao.cardAdd(new Bc(name, company, department, position, address, email, phone_number, post_code, memo, id))) {	// 登録成功
//			request.setAttribute("result",　new Result("登録成功！", "レコードを登録しました。", "/simpleBC/MenuServlet"));
			System.out.println("登録は成功しました。");
		}
		else {												// 登録失敗
//			request.setAttribute("result",　new Result("登録失敗！", "レコードを登録できませんでした。", "/simpleBC/MenuServlet"));
			System.out.println("登録は失敗しました。");
		}

		// 結果ページにフォワードする
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
		response.sendRedirect("MenuServlet");
//		dispatcher.forward(request, response);
	}
}
