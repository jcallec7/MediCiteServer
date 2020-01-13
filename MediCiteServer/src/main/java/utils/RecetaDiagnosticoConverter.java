package utils;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Receta;
import modelo.Usuario;
import vista.GestionConsultaBean;
import vista.GestionDiagnosticoBean;

@FacesConverter(value = "recetaDiagnosticoConverter")
public class RecetaDiagnosticoConverter implements Converter {
	 @Override
	    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String beerId) {
	        ValueExpression vex =
	                ctx.getApplication().getExpressionFactory()
	                        .createValueExpression(ctx.getELContext(),
	                                "#{gestionDiagnosticoBean}", GestionDiagnosticoBean.class);
	        GestionDiagnosticoBean beers = (GestionDiagnosticoBean)vex.getValue(ctx.getELContext());
	        for(Receta a : beers.getRecetas()) {
	        	System.out.println("id " + a.getId() + "  " + beerId);
	        	if(a.getId() == Integer.parseInt(beerId)) {
	        		System.out.println(a);
	        		return a;
	        	}
	        }
	        System.out.println("no encontrado");
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object beer) {
	        return "" + ((Receta)beer).getId();
	    }

}
