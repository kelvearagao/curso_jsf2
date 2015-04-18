package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.sun.istack.internal.Nullable;

@Entity
@Table(name="cities")
public class City implements Serializable{
	@Id
	@Column
	long id;
	@Column
	String name;
	@Column
	String slug;
	@Column
	long state_id;
	@Column
	String clean_name;
	/*
	@Column(nullable=true)
	Long favorite_hotel = null;*/
	
	@OneToOne(optional=true)
	@JoinColumn(name="favorite_hotel")
	Hotel hotel;
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
/*
	public Long getFavorite_hotel() {
		return favorite_hotel;
	}

	public void setFavorite_hotel(Long favorite_hotel) {
		this.favorite_hotel = favorite_hotel;
	}
	*/

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getClean_name() {
		return clean_name;
	}
	
	public void setClean_name(String clean_name) {
		this.clean_name = clean_name;
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
	
	public long getState_id() {
		return state_id;
	}
	
	public void setState_id(long state_id) {
		this.state_id = state_id;
	}
	
	
}
