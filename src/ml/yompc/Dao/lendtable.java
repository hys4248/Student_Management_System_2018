package ml.yompc.Dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ml.yompc.Entity.lendtableEntity;

/**
 * Servlet implementation class lendtable
 */
@WebServlet("/lendtable")
public class lendtable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lendtable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String username = null;
        
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0)
        {
            for(Cookie c : cookies)
            {
                if(c.getName().equalsIgnoreCase("name"))
                {
                    username = c.getValue();
                    
               }
               
               
            }
       }
        if(username==null){
        	response.sendRedirect("error.html");
        	
        }
		
		
		lendtableDao lendtableDao =new lendtableDao();
		lendtableDao.lendtablestu(Integer.parseInt(username));
		List<lendtableEntity> lendtables = lendtableDao.getlendtableAll();
		request.setAttribute("lendtables",lendtables);
		request.getRequestDispatcher("/Returnbooks.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
