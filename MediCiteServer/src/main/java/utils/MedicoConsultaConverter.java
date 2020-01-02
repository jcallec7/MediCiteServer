package utils;

	import javax.el.ValueExpression;
	import javax.faces.component.UIComponent;
	import javax.faces.context.FacesContext;
	import javax.faces.convert.Converter;
	import javax.faces.convert.FacesConverter;

import modelo.Medico;
import vista.GestionConsultaBean;

	@FacesConverter(value = "medicoConsultaConverter")
	public class MedicoConsultaConverter implements Converter {

	    @Override
	    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String beerId) {
	        ValueExpression vex =
	                ctx.getApplication().getExpressionFactory()
	                        .createValueExpression(ctx.getELContext(),
	                                "#{gestionConsultaBean}", GestionConsultaBean.class);
	        GestionConsultaBean beers = (GestionConsultaBean)vex.getValue(ctx.getELContext());
	        for(Medico a : beers.getMedicos()) {
	        	System.out.println("id " + a.getId() + "  " + beerId);
	        	if(a.getId().equals(beerId)) {
	        		System.out.println(a);
	        		return a;
	        	}
	        }
	        System.out.println("no encontrado");
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object beer) {
	        return "" + ((Medico)beer).getId();
	    }

	}
