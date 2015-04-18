package controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Country;
import repository.CountryRepository;
import util.Repository;

@ManagedBean
@ViewScoped
public class CountryBean implements Serializable{
	private static final long serialVersionUID = -9200185959316584738L;
	Repository repository = new Repository();
	List<Country> countries = new ArrayList<Country>();
	Country country = new Country();
	
	@PostConstruct
	public void init() {
		System.out.println("kelve --> Iniciando Managed Bean!");
		CountryRepository countryRepository = repository.getCountryRepository();
		this.countries = countryRepository.all();
	}

	public List<Country> getCountries() {
		return countries;
	}
	
	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public String save() {
		CountryRepository countryRepository = repository.getCountryRepository();
		countryRepository.save(this.country);
		
		return "list";
	}
	
	public void delete() {
		System.out.println("Kelve --> Deletando...");
		CountryRepository countryRepository = repository.getCountryRepository();
		countryRepository.delete(country);
		System.out.println("Kelve --> Sucesso ao deletar!");
		this.init();
		System.out.println("Kelve --> Recarregando a lista!");
	}
	
	public String edit() {
		return "edit";
	}
	
	public String update() {
		CountryRepository countryRepository = repository.getCountryRepository();
		countryRepository.update(country);
		
		return "list";
	}
}
