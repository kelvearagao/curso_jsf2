package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="types")
public class Type implements Serializable{
	@Id
	long id;
	@Column
	String type;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
/*
<h:selectOneMenu value="" for="type">
<f:selectItem value="-- --" noSelectionOption="true" id="type"/>
<f:selectItems
	value="#{hotelBean.types}"
	var="type"
	itemLabel="#{type.type}"
	itemValue="#{type.id}"
/> 
</h:selectOneMenu>
*/