package vista;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import modelo.Certificado;
import modelo.Consulta;
import negocio.GestionCertificadoLocal;
import negocio.GestionConsultaLocal;

@ManagedBean
@SessionScoped
public class GestionCertificadoBean {
	
	@Inject
	private GestionConsultaLocal gcl;
	
	@Inject
	private GestionCertificadoLocal gcel;
	
	/* Beans properties */
	private int id;
	private Date fecha;
	private Consulta consulta;
	private String descripcion;
	
	private List<Consulta> consultas;
	private List<Certificado> certificados;
	
	private String filtro;
	private Consulta selectedConsulta;
	private Certificado editCertificado;
	
	@PostConstruct
	public void init() {
		listConsultas();
		//listCertificados();
	}
	
	

	

	public GestionConsultaLocal getGcl() {
		return gcl;
	}





	public void setGcl(GestionConsultaLocal gcl) {
		this.gcl = gcl;
	}





	public GestionCertificadoLocal getGcel() {
		return gcel;
	}





	public void setGcel(GestionCertificadoLocal gcel) {
		this.gcel = gcel;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public Date getFecha() {
		return fecha;
	}





	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}





	public Consulta getConsulta() {
		return consulta;
	}





	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}





	public String getDescripcion() {
		return descripcion;
	}





	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}





	public List<Consulta> getConsultas() {
		return consultas;
	}





	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}





	public List<Certificado> getCertificados() {
		return certificados;
	}





	public void setCertificados(List<Certificado> certificados) {
		this.certificados = certificados;
	}





	public String getFiltro() {
		return filtro;
	}





	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}





	public Consulta getSelectedConsulta() {
		return selectedConsulta;
	}





	public void setSelectedConsulta(Consulta selectedConsulta) {
		this.selectedConsulta = selectedConsulta;
	}





	public Certificado getEditCertificado() {
		return editCertificado;
	}





	public void setEditCertificado(Certificado editCertificado) {
		this.editCertificado = editCertificado;
	}





	public String guardarCertificado() {
		System.out.println(selectedConsulta);
		gcel.guardarCertificado(id, fecha, selectedConsulta, descripcion);
		certificados = gcel.getCertificados();
		return null;
		
	}
	
	public List<Certificado> buscarCertificado() {
		certificados = gcel.getCertificadoPorId(filtro);
		return certificados;
	}
	
	public String deleteCertificado() {
		return null;
	}
	
	public void listConsultas() {
		this.consultas = this.gcl.getConsultas();
	}
	
	public void listCertificados() {
		this.certificados = this.gcel.getCertificados();
	}
	

}
