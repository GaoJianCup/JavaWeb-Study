package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;

import dbtools.SqlSessionTool;
import orm.mapper.UserMapper;
import orm.po.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username, password);
		SqlSession sqlSession = SqlSessionTool.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		user=userMapper.loginByUsernameAndPassword(user);
		if (user!=null) {
			response.sendRedirect("messagesServlet");
		}else {
			response.getWriter().println("error!!!");
			return;
		}	
		
		HttpSession session=request.getSession();
		session.setAttribute("user", user);
	}

}
