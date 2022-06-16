package kr.co.jhta.project.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ConnectionManager {

	private static ConnectionManager cm = new ConnectionManager();

	private ConnectionManager() {}
	
	public static ConnectionManager getInstance() {
		return cm;
	}
	
	SqlSessionFactory factory = null;

	public SqlSessionFactory getFactory() {
		
		try {
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");

			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			factory = ssfb.build(r);
			r.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return factory;
	}
}
