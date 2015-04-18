package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Type;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

@FacesConverter(forClass=Type.class)
public class TypeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if( value == null )
			return null;
		
		System.out.println("Converter: " + value + " !!!");
		
		Session session = (Session) HibernateUtil.getRequestAttribute("session");
		Criteria criteria = session.createCriteria(Type.class);
		
		criteria.add(Restrictions.eq("id", Long.valueOf(value)));
		criteria.setMaxResults(1);
		
		Type type = (Type) criteria.uniqueResult();
		
		System.out.println("Converter: " + type.getType()  + " !!!");
		return type;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object obj) {
		if (obj != null) {
			System.out.println("Pegando a string");
			String id = Long.toString(((Type) obj).getId());
			System.out.println("Sucesso ao pegar a string");
			return id;
		}
		
		return null;
	}
}
