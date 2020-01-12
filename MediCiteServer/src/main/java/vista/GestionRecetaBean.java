package vista;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import modelo.Detalle;
import modelo.Medicamento;
import modelo.Receta;
import negocio.GestionDetalleLocal;
import negocio.GestionMedicamentoLocal;
import negocio.GestionRecetaLocal;

@ManagedBean
@SessionScoped
public class GestionRecetaBean {

	@Inject
	private GestionRecetaLocal grl;

	@Inject
	private GestionDetalleLocal gdl;

	//@Inject
	//private GestionMedicamentoLocal gml;

	/* Beans properties */

	private int id;
	private String descr;
	private List<Detalle> detalles;
	//private List<Medicamento> medicamentos;
	private List<Receta> recetas;

	private String filtro;
	private int currentRecetaId;
	private int editReceta;
	private Detalle selectedDetalle;
	private Receta selectedReceta;

	@PostConstruct
	public void init() {
		listDetalles();
		//listMedicamentos();
		listRecetas();
	}
	
	public Receta getSelectedReceta() {
		return selectedReceta;
	}

	public void setSelectedReceta(Receta selectedReceta) {
		this.selectedReceta = selectedReceta;
	}
/*
	public GestionMedicamentoLocal getGml() {
		return gml;
	}

	public void setGml(GestionMedicamentoLocal gml) {
		this.gml = gml;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}
	*/

	public int getCurrentRecetaId() {
		return currentRecetaId;
	}

	public void setCurrentRecetaId(int currentRecetaId) {
		this.currentRecetaId = currentRecetaId;
	}

	public int getEditReceta() {
		return editReceta;
	}

	public void setEditReceta(int editReceta) {
		this.editReceta = editReceta;
	}

	public Detalle getSelectedDetalle() {
		return selectedDetalle;
	}

	public void setSelectedDetalle(Detalle selectedDetalle) {
		this.selectedDetalle = selectedDetalle;
	}

	public GestionRecetaLocal getGrl() {
		return grl;
	}

	public void setGrl(GestionRecetaLocal grl) {
		this.grl = grl;
	}

	public GestionDetalleLocal getGdl() {
		return gdl;
	}

	public void setGdl(GestionDetalleLocal gdl) {
		this.gdl = gdl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public List<Detalle> getDetalles() {
		
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	private void listDetalles() {
		this.detalles = this.gdl.getDetalles();
	}

	private void listRecetas() {
		this.detalles = this.gdl.getDetalles();
		//this.medicamentos = this.gml.getMedicamento();
		//this.recetas = this.grl.getRecetas();
	}
	
	/*
	private void listMedicamentos() {
		this.medicamentos = this.gml.getMedicamento();
	}
	
	*/

	public String guardarReceta() {

		System.out.println(selectedDetalle);
		List<Detalle> aux = new ArrayList<>();
		aux.add(selectedDetalle);
		grl.guardarReceta(id, descr, aux);
		recetas = grl.getRecetas();
		return "listReceta";

	}

	public List<Receta> buscarReceta() {

		recetas = grl.getRecetaPorNombre(filtro);

		return recetas;
	}
	
	public String listarDetalles() {
		
		this.currentRecetaId = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedRecetaId"));
		this.selectedReceta = this.grl.readReceta(this.currentRecetaId);
		this.gdl.getDetalles();
		System.out.println("*"+currentRecetaId+"*");
		System.out.println("*"+selectedReceta+"*");
		//this.gml.getMedicamento();
		this.detalles = this.selectedReceta.getDetalle();
		return "listDetalle";
	}
	
	// public String updateMedicamento() {
	// gdl.updateDetalle(id, nombre, medicamento);
	// return "listDetalle";
	// }

}
