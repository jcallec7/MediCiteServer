package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.FacturaDAO;
import modelo.Consulta;
import modelo.Factura;


import java.util.ArrayList;
import java.util.Date;

@Stateless
public class GestionFactura implements GestionFacturaLocal, GestionFacturaRemote
{
	@Inject
	private FacturaDAO dao;
	
	private List<Factura> factura = new ArrayList<Factura>();

	
	public void guardarFactura(int id, String nombre, String cedulaRuc, String direccion, Consulta consulta, double subtotal, double total, Date fecha) {
		
		Factura f = new Factura();
		f.setId(id);
		f.setNombre(nombre);
		f.setCedulaRuc(cedulaRuc);
		f.setDireccion(direccion);
		f.setConsulta(consulta);
		f.setSubtotal(subtotal);
		f.setTotal(total);
		f.setFecha(fecha);
		System.out.println(f);
		dao.insert(f);
	}
	
	
	public void eliminarFactura(int id) {
		System.err.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/ FACTURA ELIMINADA /*/*/*/*/*/*/*/*/*//**/");
		dao.remove(id);
	}
	

	@Override
	public void modificarFactura(int id, String nombre, String cedulaRuc, String direccion, Consulta consulta, double subtotal, double total, Date fecha) {
		
		Factura f = new Factura();
		f.setId(id);
		f.setNombre(nombre);
		f.setCedulaRuc(cedulaRuc);
		f.setDireccion(direccion);
		f.setConsulta(consulta);
		f.setSubtotal(subtotal);
		f.setTotal(total);
		f.setFecha(fecha);
		System.out.println(f);
		dao.update(f);
	}

	@Override
	public Factura leerFactura(int id) {
		Factura facturas = dao.read(id);
		System.out.println(facturas);
		return facturas;
	}

	@Override
	public List<Factura> getFactura() {
		System.out.println(factura);
		return dao.getFactura();
	}


	@Override
	public List<Factura> getFacturaPorId(String filtro) {
		// TODO Auto-generated method stub
		return dao.getFacturaXNombre(filtro);
	}


}
