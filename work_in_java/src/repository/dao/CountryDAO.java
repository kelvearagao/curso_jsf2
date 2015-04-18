package repository.dao;

import java.util.List;

import org.hibernate.Session;

import model.Country;
import repository.CountryRepository;

public class CountryDAO implements CountryRepository {
	
	private Session session;
	
	public CountryDAO(Session session) {
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Country> all() {
		return session.createCriteria(Country.class).list();
	}

	@Override
	public Country byId(int id) {
		return (Country) session.get(Country.class, id);
	}

	@Override
	public void save(Country country) {
		session.save(country);
	}
	
	@Override
	public void delete(Country country) {
		session.delete(country);
	}
	
	@Override
	public void update(Country country) {
		session.update(country);
	}
}
