package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String code;
	private int paxes;
	private int adults;
	private int childs;
	private float total_price;
	private String currency;
	

	@Id
	@Column(name = "id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column
	public int getPaxes() {
		return paxes;
	}
	public void setPaxes(int paxes) {
		this.paxes = paxes;
	}
	
	@Column
	public int getAdults() {
		return adults;
	}
	public void setAdults(int adults) {
		this.adults = adults;
	}
	
	@Column
	public int getChilds() {
		return childs;
	}
	public void setChilds(int childs) {
		this.childs = childs;
	}
	
	@Column
	public float getTotal_price() {
		return total_price;
	}
	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}
	
	@Column
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adults;
		result = prime * result + childs;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + (int) id;
		result = prime * result + paxes;
		result = prime * result + Float.floatToIntBits(total_price);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (adults != other.adults)
			return false;
		if (childs != other.childs)
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (id != other.id)
			return false;
		if (paxes != other.paxes)
			return false;
		if (Float.floatToIntBits(total_price) != Float
				.floatToIntBits(other.total_price))
			return false;
		return true;
	}
}
