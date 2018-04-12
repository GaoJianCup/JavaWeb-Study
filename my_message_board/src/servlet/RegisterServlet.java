package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import dbtools.SqlSessionTool;
import orm.mapper.UserMapper;
import orm.po.User;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = new User(username, password);
			SqlSession sqlSession = SqlSessionTool.getSqlSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.registerUser(user);
			SqlSessionTool.commit();
			response.sendRedirect("login.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("register.jsp");
		}
		
	}

}
