package pl.myspringboothibernateapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.type.TrueFalseType;

@Entity
@Table(name="user")
public class User implements Serializable{
	private static final long serialVersionUID = -7533996434173519473L;
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id_user")
		private Long id;
		@Column(nullable=false, unique=true)
		private String username;
		@Column(nullable=false)
		private String password;
		@Column(nullable=false, unique=true)
		private String email;
		@OneToOne
		@JoinColumn(name="id_details")
		private UserDetails userDetails;
		
		public User() {
			
		}
		
		public User(String username, String password, String email) {
			this.username = username;
			this.password = password;
			this.email = email;
		}

		public Long getId() {
			return id;
		}

		public String getUsername() {
			return username;
		}

		public String getPassword() {
			return password;
		}

		public String getEmail() {
			return email;
		}

		public UserDetails getUserDetails() {
			return userDetails;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setUserDetails(UserDetails userDetails) {
			this.userDetails = userDetails;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
					+ ", userDetails=" + userDetails + "]";
		}
		
		
}
