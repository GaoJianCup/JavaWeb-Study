package dbtools;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactorySingleton {
	
	private enum Singleton{
		INSTANCE;
		
		private SqlSessionFactory sqlSessionFactory;
		
		private SqlSessionFactory getInsyance() {
			try {
				if (sqlSessionFactory == null) {
					InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
					sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return sqlSessionFactory;
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return Singleton.INSTANCE.getInsyance();
	}
}
