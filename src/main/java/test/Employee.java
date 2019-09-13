package test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="EmpTest")
public class Employee {
	 
	   public Employee() {
	       
	   }
	   public Employee(Integer id, String firstName, String lastName, String email) {
	      super();
	      this.id = id;
	      this.firstName = firstName;
	      this.lastName = lastName;
	      this.email = email;
	   }
	   
	   @Id
	   @GeneratedValue
	   @Column(name = "id", updatable = false, nullable = false)
	   private Integer id;
	   @NonNull
	   private String firstName;
	   @NonNull
	   private String lastName;
	   @NonNull
	   private String email;
	    
	   //getters and setters
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	@Override
	   public String toString() {
	      return "Employee [id=" + id + ", firstName=" + firstName
	            + ", lastName=" + lastName + ", email=" + email + "]";
	   }
	}