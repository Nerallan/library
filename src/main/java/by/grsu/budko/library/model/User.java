package by.grsu.budko.library.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;

	@Column(name = "name")
	@NotEmpty(message = "*Please provide your name")
	private String name;

	@Column(name = "last_name")
	@NotEmpty(message = "*Please provide your last name")
	private String lastName;

	@Column(name = "email")
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String email;


	@Column(name = "password")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	@Transient
	private String password;

	@Column(name = "active")
	private int active;

	@Column(name = "balans")
	private int balans;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	public User(){super();}

	public User(String name, String lastName, String email, int balans, int active) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.balans = balans;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBalans() {
		return balans;
	}

	public void setBalans(int balans) {
		this.balans = balans;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(HashSet<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", active=" + active +
				", balans=" + balans +
				", roles=" + roles +
				'}';
	}
}
