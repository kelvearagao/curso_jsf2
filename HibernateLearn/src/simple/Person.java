package simple;

import javax.persistence.*;

public class Person {
	String name;
	
	public Person() {}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
	
}
