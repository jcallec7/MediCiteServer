package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import datos.ConsultaDAO;
import datos.FacturaDAO;
import datos.UsuarioDAO;
import modelo.Consulta;
import modelo.Factura;
import modelo.Usuario;

import java.util.ArrayList;
import java.util.Date;

@Stateless
@SessionScoped
public class GestionFactura implements GestionFacturaLocal, GestionFacturaRemote {
	
	@Inject
	private FacturaDAO dao;

	@Inject
	private ConsultaDAO daoConsulta;
	
	@Inject
	private UsuarioDAO daoUsuario;

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

	public Factura leerFactura(int id) {
		Factura facturas = dao.read(id);
		daoConsulta.getConsultas();
		daoUsuario.getUsuarioPorRol(4);
		daoUsuario.getUsuarioPorRol(3);
		facturas.getConsulta();
		facturas.getConsulta().getMedico();
		facturas.getConsulta().getUsuario();
		return facturas;
	}

	public List<Factura> getFactura() {
		System.out.println(factura);
		List<Consulta> consultas = daoConsulta.getConsultas();
		List<Usuario> pacientes = daoUsuario.getUsuarioPorRol(4);
		List<Usuario> medicos = daoUsuario.getUsuarioPorRol(3);		
		return dao.getFactura();
	}

	public List<Factura> getFacturaPorId(String filtro) {
		// TODO Auto-generated method stub
		return dao.getFacturaXNombre(filtro);
	}

}
