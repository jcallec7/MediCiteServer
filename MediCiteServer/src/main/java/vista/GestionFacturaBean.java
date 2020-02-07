package vista;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import modelo.Factura;
import modelo.Usuario;
import modelo.Consulta;
import negocio.GestionConsultaLocal;
import negocio.GestionFacturaLocal;
import negocio.GestionUsuarioLocal;

@ManagedBean
@ViewScoped
public class GestionFacturaBean {
	
	@Inject
	private GestionFacturaLocal gfl;

	@Inject
	private GestionConsultaLocal gcl;
	
	@Inject
	private GestionUsuarioLocal gul;

	private int id;
	private String nombre;
	private String cedulaRuc;
	private String direccion;
	private Consulta consulta;
	private double subtotal;
	private double total;
	private Date fecha;
	private String filtro;

	private List<Usuario> medicos;
	private List<Usuario> usuarios;
	private List<Factura> facturas;
	private List<Consulta> consultas;

	private Consulta selectedConsulta;
	private int hora;
	private int minuto;

	@PostConstruct
	public void init() {
		listFacturas();
		listUsuarios();
		listMedicos();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedulaRuc() {
		return cedulaRuc;
	}

	public void setCedulaRuc(String cedulaRuc) {
		this.cedulaRuc = cedulaRuc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public GestionConsultaLocal getGcl() {
		return gcl;
	}

	public void setGcl(GestionConsultaLocal gcl) {
		this.gcl = gcl;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public Consulta getSelectedConsulta() {
		return selectedConsulta;
	}

	public void setSelectedConsulta(Consulta selectedConsulta) {
		this.selectedConsulta = selectedConsulta;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	private Factura facturaEd;

	public GestionFacturaLocal getGfl() {
		return gfl;
	}

	public void setGfl(GestionFacturaLocal gfl) {
		this.gfl = gfl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura getFacturaEd() {
		return facturaEd;
	}

	public void setFacturaEd(Factura facturaEd) {
		this.facturaEd = facturaEd;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String guardarFactura() {
		gfl.guardarFactura(id, nombre, cedulaRuc, direccion, consulta, subtotal, subtotal, fecha);
		facturas = gfl.getFactura();
		return "listFactura";

	}

	public String editarFactura() {
		this.facturaEd = gfl.leerFactura(id);
		return "updateFactura";
	}

	public String eliminarFactura(int id) {
		gfl.eliminarFactura(id);
		return "listFactura";
	}

	public List<Factura> buscarFactura() {
		facturas = gfl.getFacturaPorId(filtro);
		return facturas;
	}

	public void listConsultas() {
		this.consultas = this.gcl.getConsultas();
		this.gul.getUsuarios();
	}

	public void listFacturas() {
		this.facturas = this.gfl.getFactura();
	}
	
	public void listUsuarios() {
		this.usuarios = this.gul.getUsuarioPorRol(4);
	}

	public void listMedicos() {
		this.medicos = this.gul.getUsuarioPorRol(3);
	}

}
