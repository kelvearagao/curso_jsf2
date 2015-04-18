package controle;

import infra.CityDAO;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.City;

@ManagedBean
@SessionScoped
public class CityBean {
	City city;
	List<City> cities;
	CityDAO cityDAO = new CityDAO();
	
	public City getCity() {
		return city;
	}
	
	public void setCity(City city) {
		this.city = city;
	}
	
	public List<City> getCities() {
		return cityDAO.getCities();
	}
}
