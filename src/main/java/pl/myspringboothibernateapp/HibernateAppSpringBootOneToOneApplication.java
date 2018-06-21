package pl.myspringboothibernateapp;

import org.hibernate.exception.spi.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.myspringboothibernateapp.dao.UserDao;
import pl.myspringboothibernateapp.dao.UserDetailsDao;
import pl.myspringboothibernateapp.model.User;
import pl.myspringboothibernateapp.model.UserDetails;

@SpringBootApplication
public class HibernateAppSpringBootOneToOneApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(HibernateAppSpringBootOneToOneApplication.class, args);
		UserDao userDao = ctx.getBean(UserDao.class);
		
		//Create
		User user = new User("Emil Karpowicz", "Poslka01","emil.karpowicz@gmail.com");
		UserDetails userDetails = new UserDetails("Emil", "Karpowicz", "Suwałki");
		user.setUserDetails(userDetails);
		userDao.save(user);
		
		//Update

		User newUser = new User("PaulinaJaroszewska", "Poslka01","paulina.jaroszewska@gmail.com");
		UserDetails newUserDetails = new UserDetails("Paulina", "Jaroszewska", "Suwałki");
		user.setUserDetails(userDetails);
		userDao.update(newUser);
		
		//Read
		
		User userFromDb = userDao.get(1L);
		System.out.println(userFromDb);
		
		//Delete
		// userDao.remove(userFromDb);
		
		UserDetailsDao userDetailsDao = ctx.getBean(UserDetailsDao.class);
		UserDetails userDetailsFromDb = userDetailsDao.get(1L);
		System.out.println("To jest to:" + userDetailsFromDb.getUser());
			
		ctx.close();
	}
}
