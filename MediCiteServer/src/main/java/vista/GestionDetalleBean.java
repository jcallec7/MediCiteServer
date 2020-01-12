package vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import modelo.Medicamento;
import modelo.Consulta;
import modelo.Detalle;

import negocio.GestionConsultaLocal;
import negocio.GestionDetalleLocal;
import negocio.GestionMedicamentoLocal;

@ManagedBean
@SessionScoped
public class GestionDetalleBean {
	
	@Inject
	private GestionDetalleLocal gdl;
	
	@Inject
	private GestionMedicamentoLocal gml;

	/* Beans properties */
	private String id;
	private String nombre;
	private Medicamento medicamento;
	
	
	private List<Detalle> detalles;
	private List<Medicamento> medicamentos;
	
	private String filtro;
	private Detalle editDetalle;
	private Medicamento selectedMedicamento;
	private Medicamento selectedMedicamento2;
	
	@PostConstruct
	public void init() {
		listDetalles();
		listMedicamentos();
	}



	public GestionDetalleLocal getGdl() {
		return gdl;
	}

	public void setGdl(GestionDetalleLocal gdl) {
		this.gdl = gdl;
	}

	public GestionMedicamentoLocal getGml() {
		return gml;
	}

	public void setGml(GestionMedicamentoLocal gml) {
		this.gml = gml;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public Detalle getEditDetalle() {
		return editDetalle;
	}

	public void setEditDetalle(Detalle editDetalle) {
		this.editDetalle = editDetalle;
	}

	public Medicamento getSelectedMedicamento() {
		return selectedMedicamento;
	}

	public void setSelectedMedicamento(Medicamento selectedMedicamento) {
		this.selectedMedicamento = selectedMedicamento;
	}
	
	public Medicamento getSelectedMedicamento2() {
		return selectedMedicamento2;
	}



	public void setSelectedMedicamento2(Medicamento selectedMedicamento2) {
		this.selectedMedicamento2 = selectedMedicamento2;
	}



	private void listDetalles() {
		this.detalles = this.gdl.getDetalles();
	}
	
	
	
	private void listMedicamentos() {
		this.medicamentos = this.gml.getMedicamento();
		
	}
	
	
	public String guardarDetalle() {
		
		System.out.println(selectedMedicamento);
		gdl.guardarDetalle(id, nombre, selectedMedicamento);
		detalles = gdl.getDetalles();
		return "listDetalle";

	}
	
	public List<Detalle> buscarDetalle() {

		detalles = gdl.getDetallesPorNombre(filtro);

		return detalles;
	}
	
	public String editarDetalle(String id) {
		this.editDetalle = gdl.leerDetalle(id);
		return "updateDetalle";
	}
	
	public String eliminarDetalle(String id) {
		gdl.eliminarDetalles(id);
		return "listDetalle";
	}
	
	public String actualizarDetalle() {
		gdl.updateDetalle(id, nombre, selectedMedicamento2);
		return "listDetalle";
	}
	
	
	
}
