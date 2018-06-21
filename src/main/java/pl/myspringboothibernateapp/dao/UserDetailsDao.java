package pl.myspringboothibernateapp.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.myspringboothibernateapp.model.User;
import pl.myspringboothibernateapp.model.UserDetails;

@Repository
@Transactional
public class UserDetailsDao{

	private EntityManager entityManager;

	@Autowired
	public UserDetailsDao(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public UserDetails get(Long id) {
		
		UserDetails userDetails = entityManager.find(UserDetails.class, id);
		return userDetails;
	}

}
