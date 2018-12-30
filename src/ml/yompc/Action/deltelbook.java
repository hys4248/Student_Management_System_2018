package ml.yompc.Action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ml.yompc.Dao.bookstuDao;

/**
 * Servlet implementation class deltelbook
 */
@WebServlet("/deltelbook")
public class deltelbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deltelbook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stuId =request.getParameter("stuId");
		System.out.println(stuId);
		bookstuDao bookstuDao =new bookstuDao();
		bookstuDao.deletebookstu(Integer.parseInt(stuId));
		
		//request.getRequestDispatcher("/bookstusview").forward(request,response);
		response.sendRedirect("bookstusview");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
