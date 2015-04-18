package model;
 
import java.io.Serializable;
 
import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;    
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "STUDENT") 
public class Student implements Serializable {
 
	 private static final long serialVersionUID = 5502738307095121008L;
	 
	 @Id  
	 @GeneratedValue
	 @Column(name = "STUDENT_ID")  
	 private int id;
	  
	 @Column(name="FIRST_NAME")   
	 private String firstname;
	  
	 @Column(name="LAST_NAME")     
	 private String lastname;
	  
	 @Column(name="SECTION")   
	 private String section;
	     
	 @OneToOne(mappedBy="student", cascade = CascadeType.ALL)  
	 private Address address;
	     
	    public Student(){
	      
	    }
	     
	 public Student(String rollno, String firstname, String lastname,
	   String course, Address address) {
	  super();
	  this.section = rollno;
	  this.firstname = firstname;
	  this.lastname = lastname;
	  this.section = course;
	  this.address = address;
	 }
	 
	 
	 
	 public int getId() {
	  return id;
	 }
	 
	 public void setId(int id) {
	  this.id = id;
	 }
	 
	 public String getRollno() {
	  return section;
	 }
	 
	 public void setRollno(String rollno) {
	  this.section = rollno;
	 }
	 
	 public String getFirstname() {
	  return firstname;
	 }
	 
	 public void setFirstname(String firstname) {
	  this.firstname = firstname;
	 }
	 
	 public String getLastname() {
	  return lastname;
	 }
	 
	 public void setLastname(String lastname) {
	  this.lastname = lastname;
	 }
	 
	 public String getCourse() {
	  return section;
	 }
	 
	 public void setCourse(String course) {
	  this.section = course;
	 }
	 
	 public Address getAddress() {
	  return address;
	 }
	 
	 public void setAddress(Address address) {
	  this.address = address;
	 }
}