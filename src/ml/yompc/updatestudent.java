package ml.yompc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ml.yompc.Entity.booktypeEntity;
import ml.yompc.Entity.publicherEntity;

/**
 * Servlet implementation class updatestudent
 */
@WebServlet("/updatestudent")
public class updatestudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		StudentDao studentDao = new StudentDao();
		List<booktypeEntity> booktypeEntities=studentDao.getbooktypeEntity();
		List<publicherEntity> publicherEntities=studentDao.getpublicherEntity();
		request.setAttribute("publicherEntities", publicherEntities);
		request.setAttribute("booktypeEntities", booktypeEntities);
		String bookId = request.getParameter("bookId");
		request.getRequestDispatcher("/update.jsp").forward(request,response);
	}

}
