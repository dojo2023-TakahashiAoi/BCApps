package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BcDAO;
import model.Bc;
import model.Result;

/**
 * Servlet implementation class UpdateDeleteServlet
 */
@WebServlet("/UpdateDeleteServlet")
public class UpdateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

		System.out.println("サーブレットを開始します.");

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("UUID");
		String name = request.getParameter("NAME");
		String company = request.getParameter("COMPANY");
		String department = request.getParameter("DEPARTMENT");
		String position = request.getParameter("POSITION");
		String address = request.getParameter("ADDRESS");
		String email = request.getParameter("EMAIL");
		String phone_number = request.getParameter("PHONE_NUMBER");
		String post_code = request.getParameter("POST_CODE");
		String memo = request.getParameter("MEMO");

		System.out.println("更新データ（名前）" + name);

		// 更新または削除を行う
		BcDAO bDao = new BcDAO();
		System.out.println("削除または更新を選択しています...");
		if (request.getParameter("SELECT").equals("登録する")) {
			Bc bc = new Bc();
			bc.update(id, name, company, department, position, address, email, phone_number, post_code, memo);

			if (bDao.update(bc)) {	// 更新成功
				request.setAttribute("result", new Result("更新成功！", "レコードを更新しました。", "/simpleBC/MenuServlet"));
				System.out.println("更新成功！");
			}
			else { // 更新失敗
				request.setAttribute("result", new Result("更新失敗！", "レコードを更新できませんでした。", "/simpleBC/MenuServlet"));
				System.out.println("更新失敗！");
			}
		}
		else if (request.getParameter("SELECT").equals("delete"))  {
			System.out.println("削除開始します...");
			if (bDao.delete(id)) {	// 削除成功
				request.setAttribute("result", new Result("削除成功！", "レコードを削除しました。", "/simpleBC/MenuServlet"));
				System.out.println("削除成功！");
			}
			else { // 削除失敗
				request.setAttribute("result", new Result("削除失敗！", "レコードを削除できませんでした。", "/simpleBC/MenuServlet"));
				System.out.println("削除失敗！");
			}
		}

		// 結果ページにフォワードする
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
//		dispatcher.forward(request, response);
		response.sendRedirect("MenuServlet");
	}
}
