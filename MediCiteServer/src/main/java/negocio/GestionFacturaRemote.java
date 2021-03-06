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
	public void guardarFactura(int id, String nombre, String cedulaRuc, String direccion, Consulta consulta, double subtotal, double total, Date fecha);
	public void modificarFactura(int id, String nombre, String cedulaRuc, String direccion, Consulta consulta, double subtotal, double total, Date fecha);
	public Factura leerFactura(int id);
	public void eliminarFactura(int id);
	public List<Factura> getFactura();
}
