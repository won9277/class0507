package com.sds.icto.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.emaillist.dao.EmailListDao;
import com.sds.icto.emaillist.vo.EmailListVo;
import com.sds.icto.web.Action;
import com.sds.icto.web.FormAction;
import com.sds.icto.web.IndexAction;
import com.sds.icto.web.InsertAction;
import com.sds.icto.web.WebUtil;

/**
 * Servlet implementation class webex04
 */
@WebServlet("/el")
public class webex04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public webex04() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			request.setCharacterEncoding("utf-8");
			String a = request.getParameter("a");
			Action action = null;
			
			if ("form".equals(a)) {
				action = new FormAction();
			}else if ("insert".equals(a)){
				//이메일을 등록합니다.
				action = new InsertAction();
			} 
			
			if(action == null) {
				// default action
				action = new IndexAction();

			}
			action.execute(request, response);
			RequestDispatcher requestDispatcher = getServletContext()
					.getRequestDispatcher("/view/show_emaillist.jsp");
			requestDispatcher.forward(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
