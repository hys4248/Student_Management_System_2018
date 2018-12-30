package ml.yompc.Action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import ml.yompc.student;
import ml.yompc.Dao.bookstuDao;
import ml.yompc.Entity.bookstu;

/**
 * Servlet implementation class bookstusview
 */
@WebServlet("/bookstusview")
public class bookstusview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bookstuDao bookstudao = new bookstuDao();
		java.util.List<bookstu> bookstuss = bookstudao.getbookAll();
		request.setAttribute("bookstuss", bookstuss);
		request.getRequestDispatcher("/bookstu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
