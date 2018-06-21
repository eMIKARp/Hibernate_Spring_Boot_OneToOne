package pl.myspringboothibernateapp.dao;

import pl.myspringboothibernateapp.model.User;

public interface UserDao {
	
	public void save(User user);
	public User get(Long id);
	public void update(User user);
	public void remove(User user);

}
