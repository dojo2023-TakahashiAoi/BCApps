package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BcDAO;
import dao.UserDAO;
import model.Bc;
import model.User;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if ((String)session.getAttribute("id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}

		String id = (String)session.getAttribute("id");
		User loginUser = new User();

		// IDからユーザ情報を問い合わせる
		UserDAO uDao = new UserDAO();
		loginUser = uDao.show(new User(id));

		//　取得したユーザ情報からユーザ名を取り出し、リクエストスコープに格納する
		request.setAttribute("userName", loginUser.getName());

		// 名刺データを全件表示する
		String searchQuery = "";
		BcDAO bDao = new BcDAO();
		List<Bc> cardList = bDao.search(searchQuery, id);
		request.setAttribute("cardList", cardList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
		dispatcher.forward(request, response);

		// メニューページにフォワードする
//		request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp").forward(request, response);

//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
//		dispatcher.forward(request, response);
	}
}
