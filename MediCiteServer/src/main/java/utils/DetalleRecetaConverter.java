package utils;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Detalle;
import vista.GestionDetalleBean;
import vista.GestionRecetaBean;

@FacesConverter(value = "detalleRecetaConverter")
public class DetalleRecetaConverter implements Converter {
	
	
	@Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String beerId) {
        ValueExpression vex =
                ctx.getApplication().getExpressionFactory()
                        .createValueExpression(ctx.getELContext(),
                                "#{gestionRecetaBean}", GestionRecetaBean.class);
        GestionRecetaBean beers = (GestionRecetaBean)vex.getValue(ctx.getELContext());
        for(Detalle a : beers.getDetalles()) {
        	System.out.println("id +" + a.getId() + "+" + beerId+"+");
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
        return "" + ((Detalle)beer).getId();
    }
	

}
