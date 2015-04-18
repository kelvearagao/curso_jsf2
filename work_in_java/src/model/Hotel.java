package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import teste.Days;

import com.google.gson.Gson;

@Entity
@Table(name="hotels")
public class Hotel implements Serializable{
	/*
	public enum Stars {
		ONE('1'),
		TWO('2'),
		THREE('3'),
		FOUR('4'),
		FIVE('5');
		
		private char value;
		
		Stars(char value){
			this.value = value;
		}
		
		public char getValue()
		{
			return this.value;
		}
	}*/
	
	@Id
	@Column
	long id;
	@OneToOne
	City city;
	@Column
	String name;
	@Column
	String slug;
	@Column
	Boolean status;
	@Column
	String week_availability;
	@Column
	String clean_name;
	@OneToOne
	Type type;
	@Column
	int stars;
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	Date created_at;
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	Date updated_at;
	@Transient
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public String getCreated_at() {
		return this.formatter.format(created_at);
	}
	
	@PrePersist
	private void onCreate() {
		this.created_at = new Date();
	}
	
	public String getUpdated_at() {
		return this.formatter.format(updated_at);
	}
	
	@PreUpdate
	private void onUpdate() {
		this.updated_at = new Date();
	}
	
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	/*
	public Stars getStars() {
		return stars;
	}
	public void setStars(Stars stars) {
		this.stars = stars;
	}*/
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	//public String getWeek_availability() {
	public Days getWeek_availability() {
		Gson gson = new Gson();
		Days days = gson.fromJson(week_availability, Days.class);
		//return week_availability;
		return days;
	}
	public void setWeek_availability(String week_availability) {
		this.week_availability = week_availability;
	}
	public String getClean_name() {
		return clean_name;
	}
	public void setClean_name(String clean_name) {
		this.clean_name = clean_name;
	}
}
