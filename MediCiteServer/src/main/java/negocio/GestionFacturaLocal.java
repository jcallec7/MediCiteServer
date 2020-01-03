package negocio;

import java.util.Date;
import java.util.List;

import modelo.Consulta;
import modelo.Factura;

public interface GestionFacturaLocal
{
	public void guardarFactura(int id, Consulta consulta, double subtotal, double total, Date fecha);
	public void modificarFactura(int id, Consulta consulta, double subtotal, double total, Date fecha);
	public Factura leerFactura(int id);
	public void eliminarFactura(int id);
	public List<Factura> getFactura();
	public List<Factura> getFacturaPorId(String filtro);
	
}
