package utils;

	import javax.el.ValueExpression;
	import javax.faces.component.UIComponent;
	import javax.faces.context.FacesContext;
	import javax.faces.convert.Converter;
	import javax.faces.convert.FacesConverter;

import modelo.Consulta;
import vista.GestionConsultaBean;

	@FacesConverter(value = "FacturaConverter")
	public class FacturaConverter implements Converter {

	    @Override
	    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String beerId) {
	        ValueExpression vex =
	                ctx.getApplication().getExpressionFactory()
	                        .createValueExpression(ctx.getELContext(),
	                                "#{gestionConsultaBean}", GestionConsultaBean.class);
	        GestionConsultaBean beers = (GestionConsultaBean)vex.getValue(ctx.getELContext());
	        for(Consulta a : beers.getConsultas()) {
	        	if(a.getId()== beers.getId()) {
	        		return a;
	        	}
	        }
	        return null;
	    }

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			// TODO Auto-generated method stub
			return null;
		}


	}