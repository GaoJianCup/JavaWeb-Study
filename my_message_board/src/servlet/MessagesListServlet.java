package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import dbtools.SqlSessionTool;
import orm.mapper.MessageMapper;
import orm.po.Message;

public class MessagesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user")==null){
			response.sendRedirect("login.jsp");
			return;
		}
		
		SqlSession sqlSession =SqlSessionTool.getSqlSession();
		MessageMapper messageMapper=sqlSession.getMapper(MessageMapper.class);
		List<Message> messages=messageMapper.listMessages();
		PrintWriter out= response.getWriter();
		out.print("<table border=\"1\"><caption>All Message Detail</caption>"
				+ "<tr><td>Username</td><td>Date</td><td>Title</td><td>Content</td>");
		for (Message message : messages) {
			out.print("<tr><td>"+message.getUser()+"</td><td>"+message.getDate()+"</td><td>"
					+message.getTitle()+"</td><td>"+message.getContent()+"</td></tr>");
		}
		
		out.print("</tr></table><br>");
		out.print("<a href=\"leaveAMessage.jsp\">Leave a message<a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
