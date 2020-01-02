package utils;

	import javax.el.ValueExpression;
	import javax.faces.component.UIComponent;
	import javax.faces.context.FacesContext;
	import javax.faces.convert.Converter;
	import javax.faces.convert.FacesConverter;

import modelo.Paciente;
import vista.GestionConsultaBean;

	@FacesConverter(value = "pacienteConsultaConverter")
	public class PacienteConsultaConverter implements Converter {

	    @Override
	    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String beerId) {
	        ValueExpression vex =
	                ctx.getApplication().getExpressionFactory()
	                        .createValueExpression(ctx.getELContext(),
	                                "#{gestionConsultaBean}", GestionConsultaBean.class);
	        GestionConsultaBean beers = (GestionConsultaBean)vex.getValue(ctx.getELContext());
	        for(Paciente a : beers.getPacientes()) {
	        	if(a.getId().equals(beerId)) {
	        		return a;
	        	}
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object beer) {
	        return "" + ((Paciente)beer).getId();
	    }

	}
