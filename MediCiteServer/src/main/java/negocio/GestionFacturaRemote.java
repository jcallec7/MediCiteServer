package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import modelo.Factura;
import modelo.Consulta;

@Remote
public interface GestionFacturaRemote 
{
	public void guardarFactura(int id, Consulta consulta, double subtotal, double total, Date fecha);
	public void modificarFactura(int id, Consulta consulta, double subtotal, double total, Date fecha);
	public Factura leerFactura(int id);
	public void eliminarFactura(int id);
	public List<Factura> getFactura();
	public List<Factura> getFacturaPorId(String filtro);
}
