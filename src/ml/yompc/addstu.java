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
 * Servlet implementation class addstu
 */
@WebServlet("/addstu")
public class addstu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addstu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDao studentDao = new StudentDao();
		List<booktypeEntity> booktypeEntities=studentDao.getbooktypeEntity();
		List<publicherEntity> publicherEntities=studentDao.getpublicherEntity();
		request.setAttribute("publicherEntities", publicherEntities);
		request.setAttribute("booktypeEntities", booktypeEntities);
		request.getRequestDispatcher("/addstu.jsp").forward(request,response);
	}

}
