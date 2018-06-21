package pl.myspringboothibernateapp.dao;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.myspringboothibernateapp.model.User;
import pl.myspringboothibernateapp.model.UserDetails;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	private EntityManager entityManager;
	
	@Autowired
	public UserDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(User user) {
		UserDetails userDetails = user.getUserDetails();
		if (userDetails !=null && userDetails.getId()==null) {
			entityManager.persist(userDetails);
		}
		entityManager.persist(user);
	}

	@Override
	public User get(Long id) {
		User user = entityManager.find(User.class, id);
		return user;
	}

	@Override
	public void update(User user) {
		UserDetails userDetails = user.getUserDetails();
		if (userDetails != null) {
			userDetails = entityManager.merge(userDetails);
			user.setUserDetails(userDetails);
		}
		entityManager.merge(user);
	}

	@Override
	public void remove(User user) {
		User userToRemove = entityManager.merge(user);
		entityManager.remove(userToRemove.getUserDetails());
		entityManager.remove(userToRemove);
	}

}
