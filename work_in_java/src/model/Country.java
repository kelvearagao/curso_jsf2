package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity(name="countries")
public class Country implements Serializable{
	@Id
	int id;
	@Column
	String name;
	@Column
	String acronym;
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	Date created_at;
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	Date updated_at;
	
	@Transient
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAcronym() {
		return acronym;
	}
	
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	
	public String getCreated_at() {
		return this.formatter.format(this.created_at);
	}
	
	@PrePersist
	public void setCreated_at(Date created_at) {
		this.created_at = new Date();
	}
	
	public String getUpdated_at() {
		return this.formatter.format(this.updated_at);
	}
	
	@PreUpdate
	public void setUpdated_at(Date updated_at) {
		this.updated_at = new Date();
	}	
}