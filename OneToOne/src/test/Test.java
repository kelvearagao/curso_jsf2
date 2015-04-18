package test;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import model.Car;
import model.Engine;
import model.Student;
import model.Address;

public class Test {
	
	public static void main(String args[]){
		 Test test=new Test();
		 Address sa1 = new Address("C-42","Noida","UP","IN");
		 Address sa2 = new Address("D-61","Agra","UP","IN");
		 Student s1=new Student("CS1","Ankit","Yadav","MCA",sa1);
		 Student s2=new Student("CS2","Rahul","Jena","B.Tech",sa1);
		 sa1.setStudent(s1);
		 s1.setAddress(sa1); 
		  
		 sa2.setStudent(s2);
		 s2.setAddress(sa2); 
		  
		  
		 test.saveStudent(s1);
		 test.saveStudent(s2);
		  
		 test.getStudent();
		 System.out.println("successfully saved");
	}
	public void saveStudent(Student student) {
		   Session session = HibernateUtil.getSession();
		   session.beginTransaction();
		 
		   session.save(student);
		 
		   session.getTransaction().commit();
		    
		  }
		 
		  public void updateStudent(Student student) {
		   Session session = HibernateUtil.getSession();
		   session.beginTransaction();
		 
		   session.merge(student);
		 
		   session.getTransaction().commit();
		  }
		 
		  public void deleteStudent(Student student) {
		   Session session = HibernateUtil.getSession();
		   session.beginTransaction();
		 
		   session.delete(student);
		 
		   session.getTransaction().commit();
		  }
		 
		  public void getStudent() {
		   Session session = HibernateUtil.getSession();
		   session.beginTransaction();
		 
		   @SuppressWarnings("unchecked")
		 ArrayList<Student> list = (ArrayList<Student>) session.createQuery("from Student").list();
		   if (list != null) {
		    for (int i = 0; i < list.size(); i++) {
		     System.out.println("User ID : " + list.get(i).getId());
		     System.out.println("User First Name : "+ list.get(i).getFirstname());
		     System.out.println("User Last Name : "+ list.get(i).getLastname());
		     System.out.println("User Roll No : " + list.get(i).getRollno());
		     System.out.println("User Course : " + list.get(i).getCourse());
		     System.out.println("User Address : " + list.get(i).getAddress().getAddress() + ","+ list.get(i).getAddress().getCity() +"\n"+ list.get(i).getAddress().getState() +"\n"+ list.get(i).getAddress().getCountry());
		     
		   }
		   }
		   session.getTransaction().commit();
		  }

}
