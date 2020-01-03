package utils;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Medicamento;
import modelo.Medico;
import vista.GestionConsultaBean;
import vista.GestionDetalleBean;

@FacesConverter(value = "medicamentoDetalleConverter")
public class MedicamentoDetalleConverter implements Converter  {

	@Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String beerId) {
        ValueExpression vex =
                ctx.getApplication().getExpressionFactory()
                        .createValueExpression(ctx.getELContext(),
                                "#{gestionDetalleBean}", GestionDetalleBean.class);
        GestionDetalleBean beers = (GestionDetalleBean)vex.getValue(ctx.getELContext());
        for(Medicamento a : beers.getMedicamentos()) {
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
        return "" + ((Medicamento)beer).getId();
    }
	
	
}
