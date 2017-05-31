package pl.edu.pw.ii.eshop.dao.implementation;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pw.ii.eshop.dao.UserDao;
import pl.edu.pw.ii.eshop.model.Users;

/**
 * Klasa implementuj¹ca interfejs {@link UserDao}, wykorzystuje ORM hibernate
 * 
 * @author LucaR
 *
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Users getUserByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		// przygotowanie zapytania pobieraj¹caego z bazy danych u¿ytkownika o
		// zadanym username
		Query query = session.createQuery("from Users where username=?");
		query.setString(0, username);

		return (Users) query.uniqueResult();
	}

	@Override
	public void updateUser(Users user) {
		Session session = sessionFactory.getCurrentSession();
		// utrwalenie u¿ytkownika
		session.saveOrUpdate(user);
		session.flush();

	}

}
