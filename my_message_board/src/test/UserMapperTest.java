package test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import dbtools.SqlSessionTool;
import orm.mapper.UserMapper;
import orm.po.User;

public class UserMapperTest {

	SqlSession sqlSession = SqlSessionTool.getSqlSession();
	UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
	
	@Test
	public void testRegisterUser() {
		try {
			User user = new User();
			user.setUsername("gaojian");
			user.setPassword("123456");
			userMapper.registerUser(user);
			SqlSessionTool.commit();
		} catch (Exception e) {
			e.printStackTrace();
			SqlSessionTool.rollback();
		}
	}
	
	
	@Test
	public void testLoginByUsernameAndPassword() {
		User user = new User();
		user.setUsername("ergou");
		user.setPassword("123456");
		System.out.println(userMapper.loginByUsernameAndPassword(user));
	}
}
