package Test;

import hr.dao.UserDao;
import hr.domain.User;

import org.apache.ibatis.session.SqlSession;

public class TestUser {

	public static void main(String[] args) throws Exception{
		SqlSession session=FKSqlSessionFactory.getSqlSession();
		UserDao userDao=session.getMapper(UserDao.class);
		User user=new User();
		user.setId(3);
		user.setLoginname("tss");
		user.setPassword("123456789");
		user.setStatus(4);
		user.setUsername("sdjf");
		userDao.save(user);
		System.out.println("sdlfkjsldfkj");
		session.commit();
		session.close();
}

}
