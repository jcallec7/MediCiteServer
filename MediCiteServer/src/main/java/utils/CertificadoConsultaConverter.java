package utils;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import vista.GestionCertificadoBean;
import modelo.Consulta;


@FacesConverter(value = "certificadoConsultaConverter")
public class CertificadoConsultaConverter implements Converter{
	
	@Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String beerId) {
        ValueExpression vex =
                ctx.getApplication().getExpressionFactory()
                        .createValueExpression(ctx.getELContext(),
                                "#{gestionCertificadoBean}", GestionCertificadoBean.class);
        GestionCertificadoBean beers = (GestionCertificadoBean)vex.getValue(ctx.getELContext());
        for(Consulta a : beers.getConsultas()) {
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
        return "" + ((Consulta)beer).getId();
    }
	

}
