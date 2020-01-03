package vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import modelo.Detalle;
import modelo.Medicamento;
import modelo.Receta;
import negocio.GestionDetalleLocal;
import negocio.GestionRecetaLocal;

@ManagedBean
@SessionScoped
public class GestionRecetaBean {
	
	
	@Inject
	private GestionRecetaLocal grl;
	
	@Inject
	private GestionDetalleLocal gdl;

	/* Beans properties */
	
	private int id;
	private String descr;
	private List<Detalle> detalles;
	
	private List<Receta> recetas;

	private String filtro;
	private Receta editReceta;
	private List<Detalle> selectedDetalle;
	
	
	@PostConstruct
	public void init() {
		//listDetalles();
		listDetalles();
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




	public Receta getEditReceta() {
		return editReceta;
	}




	public void setEditReceta(Receta editReceta) {
		this.editReceta = editReceta;
	}




	public List<Detalle> getSelectedDetalle() {
		return selectedDetalle;
	}




	public void setSelectedDetalle(List<Detalle> selectedDetalle) {
		this.selectedDetalle = selectedDetalle;
	}




	private void listDetalles() {
		this.detalles = this.gdl.getDetalles();
		
	}
	
	public String guardarReceta() {
		
		System.out.println(selectedDetalle);
		grl.guardarReceta(id, descr, selectedDetalle);
		recetas = grl.getRecetas();
		return null;

	}
	
	public List<Receta> buscarReceta() {

		recetas = grl.getRecetaPorNombre(filtro);

		return recetas;
	}
	
	//public String updateMedicamento() {
	//	gdl.updateDetalle(id, nombre, medicamento);
	//	return "listDetalle";
	//}
	
}
