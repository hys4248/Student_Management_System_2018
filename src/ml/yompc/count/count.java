package ml.yompc.count;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ml.yompc.StudentDao;

/**
 * Servlet implementation class count
 */
@WebServlet("/count")
public class count extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public count() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button =request.getParameter("button");
		String countsql=null;
		String Time=request.getParameter("time");
		String Time1=request.getParameter("time1");
		String Time2=request.getParameter("time2");
		System.out.println(button);
		Date date = new Date();  
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        //时间
        String dateNowStr = sdf.format(date); 
		if (button==null) {
			countsql="SELECT `lendBookId`,`bookId`,`stuId`,`lendTime`,`returnTime`,CASE `returnFlag` WHEN 0 THEN '否' ELSE '已归还' END AS returnFlag FROM lendtable WHERE lendTime BETWEEN  '"+dateNowStr+"'  AND '"+dateNowStr+"';";
		} 
		if ("borrowreturn".equals(button)==true) {
			countsql="SELECT `lendBookId`,`bookId`,`stuId`,`lendTime`,`returnTime`,CASE `returnFlag` WHEN 0 THEN '否' ELSE '已归还' END AS returnFlag FROM lendtable WHERE lendTime BETWEEN  '"+Time+"'  AND '"+Time+"';";
		}
		if ("borrow".equals(button)==true) {
			countsql="SELECT `lendBookId`,`bookId`,`stuId`,`lendTime`,`returnTime`,CASE `returnFlag` WHEN 0 THEN '否' ELSE '已归还' END AS returnFlag FROM lendtable WHERE returnFlag=0 AND lendTime BETWEEN  '"+Time+"'  AND '"+Time+"';";
		}
		if ("return".equals(button)==true) {
			countsql="SELECT `lendBookId`,`bookId`,`stuId`,`lendTime`,`returnTime`,CASE `returnFlag` WHEN 0 THEN '否' ELSE '已归还' END AS returnFlag FROM lendtable WHERE returnFlag=1 AND lendTime BETWEEN  '"+Time+"'  AND '"+Time+"';";
		}
		//duo
		if ("borrow2".equals(button)==true) {
			countsql="SELECT `lendBookId`,`bookId`,`stuId`,`lendTime`,`returnTime`,CASE `returnFlag` WHEN 0 THEN '否' ELSE '已归还' END AS returnFlag FROM lendtable WHERE returnFlag=0 AND lendTime BETWEEN  '"+Time1+"'  AND '"+Time2+"';";
		}
		if ("return2".equals(button)==true) {
			countsql="SELECT `lendBookId`,`bookId`,`stuId`,`lendTime`,`returnTime`,CASE `returnFlag` WHEN 0 THEN '否' ELSE '已归还' END AS returnFlag FROM lendtable WHERE returnFlag=1 AND lendTime BETWEEN  '"+Time1+"'  AND '"+Time2+"';";
		}
		if ("borrowreturn2".equals(button)==true) {
			countsql="SELECT `lendBookId`,`bookId`,`stuId`,`lendTime`,`returnTime`,CASE `returnFlag` WHEN 0 THEN '否' ELSE '已归还' END AS returnFlag FROM lendtable WHERE lendTime BETWEEN  '"+Time1+"'  AND '"+Time2+"';";
		}
		
		
		counntDao counntDao=new counntDao();
		counntDao.countsql(countsql);
		List<countEntity> countEntities=counntDao.getcountALL();
		request.setAttribute("countEntities", countEntities);
		request.getRequestDispatcher("/count.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
