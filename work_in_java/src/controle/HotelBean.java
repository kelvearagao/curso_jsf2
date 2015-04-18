package controle;

import infra.HotelDAO;
import infra.TypeDAO;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Hotel;
import model.Type;

@ManagedBean
@SessionScoped
public class HotelBean implements Serializable{
	Hotel hotel = new Hotel();
	List<Hotel> hotels = null;
	List<Type> types = null;
	HotelDAO hotelDAO = new HotelDAO();
	TypeDAO typeDAO = new TypeDAO();
	
	public Hotel getHotel() {
		return hotel;
	}
	
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public List<Hotel> getHotels() {
		return hotelDAO.getHotels();
	}
	
	public List<Type> getTypes() {
		return typeDAO.getTypes();
	}
	
	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}
	
	public String create() {
		this.hotel.setClean_name("teste");
		this.hotel.setSlug("teste");
		this.hotel.setStatus(true);
		this.hotel.setWeek_availability( "{\"sun\":false,\"mon\":false,\"tue\":false,\"wed\":false,\"thu\":false,\"fri\":false,\"sat\":false}");
		this.hotelDAO.addHotel(hotel);
		
		return "list";
	}
}