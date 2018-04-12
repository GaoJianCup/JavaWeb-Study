package dbtools;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;

public class SqlSessionTool {
	private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<>();
	
	public static SqlSession getSqlSession() {
		SqlSession sqlSession=threadLocal.get();
		if (sqlSession==null) {
			sqlSession=SqlSessionFactorySingleton.getSqlSessionFactory().openSession();
			threadLocal.set(sqlSession);
		}
		return sqlSession;
	}

	public static void commit() {
		SqlSession sqlSession=threadLocal.get();
		if (sqlSession!=null) {
			sqlSession.commit();
		}
		
		System.out.println(new Date() +":数据已提交！");
	}
	
	public static void rollback() {
		SqlSession sqlSession=threadLocal.get();
		if (sqlSession!=null) {
			sqlSession.rollback();
		}
		System.out.println(new Date() +":数据已回滚！");
	}
}
