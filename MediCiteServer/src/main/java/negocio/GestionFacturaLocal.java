package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.itextpdf.text.Document;

import modelo.Consulta;
import modelo.Factura;

@Local
public interface GestionFacturaLocal
{
	public void guardarFactura(int id, String nombre, String cedulaRuc, String direccion, Consulta consulta, double subtotal, double total, Date fecha);
	public void modificarFactura(int id, String nombre, String cedulaRuc, String direccion, Consulta consulta, double subtotal, double total, Date fecha);
	public Factura leerFactura(int id);
	public void eliminarFactura(int id);
	public List<Factura> getFactura();
	public List<Factura> getFacturasPorId(String filtro);
	public void generatePDF(Factura factura);
	
}
