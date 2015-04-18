package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Country;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

@FacesConverter(forClass=Country.class)
public class CountryConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if( value == null )
			return null;
		
		System.out.println("Converter: " + value + " !!!");
		
		Session session = (Session) HibernateUtil.getRequestAttribute("session");
		Criteria criteria = session.createCriteria(Country.class);
		
		criteria.add(Restrictions.eq("id", Integer.valueOf(value)));
		criteria.setMaxResults(1);
		
		Country country = (Country) criteria.uniqueResult();
	
		return country;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object obj) {
		if (obj != null) {
			System.out.println("Pegando a string");
			String id = Integer.toString(((Country) obj).getId());
			System.out.println("Sucesso ao pegar a string");
			return id;
		}
		
		return null;
	}
}