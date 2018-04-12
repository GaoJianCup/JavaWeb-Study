package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import dbtools.SqlSessionTool;
import orm.mapper.MessageMapper;
import orm.po.Message;
import orm.po.User;

public class AddMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user")==null){
			response.sendRedirect("login.jsp");
			return;
		}
		try {
			User user = (User) request.getSession().getAttribute("user");
			Message message = new Message(user.getId(), new Date(), request.getParameter("title"),
					request.getParameter("content"));
			SqlSession sqlSession=SqlSessionTool.getSqlSession();
			MessageMapper messageMapper=sqlSession.getMapper(MessageMapper.class);
			messageMapper.insertMessage(message);
			SqlSessionTool.commit();
			response.sendRedirect("messagesServlet");
		} catch (Exception e) {
			e.printStackTrace();
			SqlSessionTool.rollback();
			response.getWriter().println("error!!!");
		}
		
	}

}
