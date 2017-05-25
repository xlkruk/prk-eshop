package pl.edu.pw.ii.eshop.dao;

import pl.edu.pw.ii.eshop.model.Users;

public interface UserDao {

	Users getUserByUsername(String username);
	void updateUser(Users user);
}
