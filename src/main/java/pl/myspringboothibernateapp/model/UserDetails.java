package pl.myspringboothibernateapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="user_details")
public class UserDetails implements Serializable{
	 private static final long serialVersionUID = 7021150458271420830L;
	 
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="id_user_details")
	 private Long id;
	 @Column(name="firstname")
	 private String firstName;
	 @Column(name="lastname")
	 private String lastName;
	 private String address;
	 @OneToOne(mappedBy = "userDetails")
	 private User user;
	 
	 	public UserDetails() {
	 		
	 	}
	
	    public UserDetails(String firstName, String lastName, String address) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.address = address;
	    }
	    
	    
	    
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Long getId() {
			return id;
		}
		public String getFirstName() {
			return firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public String getAddress() {
			return address;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		@Override
		public String toString() {
			return "UserDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
					+ address + "]";
		}
	 
}
