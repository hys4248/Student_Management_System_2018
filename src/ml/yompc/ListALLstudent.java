package ml.yompc;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ml.yompc.Entity.booktypeEntity;
import ml.yompc.Entity.publicherEntity;



/**
 * Servlet implementation class ListALLstudent
 */
@WebServlet("/ListALLstudent")
public class ListALLstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Rsql="SELECT a.`bookId`,a.`bookName`,a.`ISBN`,a.`author`,b.`publisher`,a.`pricer`,a.`total`,a.`introduction`,a.`totalLending`,c.`bookType` FROM books AS a JOIN publicher AS b ON a.publisherId=b.publisherId JOIN booktype AS c ON a.`bookTypeId`=c.`bookTypeId` ORDER BY bookId;";
		String bookTypeId = request.getParameter("bookTypeId");
		
		String publisherId=request.getParameter("publisherId");
		String bookName=request.getParameter("bookName");
		System.out.print(bookTypeId+publisherId+bookName);
		if("null".equals(bookTypeId)) {
			bookTypeId="%";
		}
		if("null".equals(publisherId)) {
			publisherId="%";
		}
		
		
		
		 if(bookTypeId!=null|publisherId!=null|bookName!=null) {
			 
			Rsql="SELECT a.`bookId`,a.`bookName`,a.`ISBN`,a.`author`,b.`publisher`,a.`pricer`,a.`total`,a.`introduction`,a.`totalLending`,c.`bookType` FROM books AS a JOIN publicher AS b ON a.publisherId=b.publisherId JOIN booktype AS c ON a.`bookTypeId`=c.`bookTypeId` WHERE a.publisherId LIKE'"+publisherId+"' AND a.`bookTypeId` LIKE'"+bookTypeId+"' AND a.bookName LIKE'"+bookName+"%' ORDER BY bookId;";
		}
		
		
		
		
		StudentDao studentDao = new StudentDao();
		studentDao.countsql(Rsql);
		List<student> students = studentDao.getALL();
		List<booktypeEntity> booktypeEntities=studentDao.getbooktypeEntity();
		List<publicherEntity> publicherEntities=studentDao.getpublicherEntity();
		request.setAttribute("publicherEntities", publicherEntities);
		request.setAttribute("booktypeEntities", booktypeEntities);
		request.setAttribute("students", students);
		request.getRequestDispatcher("/student.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
