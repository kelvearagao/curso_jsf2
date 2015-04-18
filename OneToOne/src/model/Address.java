package model;
 
import java.io.Serializable;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
 
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
 
 
 
@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {
	 private static final long serialVersionUID = 7871228112490214979L;
	 
	 @Id
	 @Column(name = "ADDRESS_ID")
	 @GeneratedValue(generator = "gen")
	 @GenericGenerator(name = "gen", strategy = "foreign",parameters = @Parameter(name = "property", value = "student"))
	 private int studentId;
	  
	 @Column(name="address")
	 private String address;
	  
	 @Column(name="city")
	 private String city;
	  
	 @Column(name="state")
	 private String state;
	  
	 @Column(name="country")
	 private String country;
	  
	 @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)  
	 private Student student;  
	 
	 public Address() {
	   
	 }  
	 
	 public int getStudentId() {
	  return studentId;
	 }
	 public Address(String address, String city, String state,
	   String country) {
	  super();
	  this.address = address;
	  this.city = city;
	  this.state = state;
	  this.country = country;
	 }
	  
	 public void setStudentId(int studentId) {
	  this.studentId = studentId;
	 }
	 public String getAddress() {
	  return address;
	 }
	 
	 public void setAddress(String address) {
	  this.address = address;
	 }
	 public String getCity() {
	  return city;
	 }
	 public void setCity(String city) {
	  this.city = city;
	 }
	 public String getState() {
	  return state;
	 }
	 public void setState(String state) {
	  this.state = state;
	 }
	 public String getCountry() {
	  return country;
	 }
	 public void setCountry(String country) {
	  this.country = country;
	 }
	 
	 public Student getStudent() {
	  return student;
	 }
	 
	 public void setStudent(Student student) {
	  this.student = student;
	 }
}