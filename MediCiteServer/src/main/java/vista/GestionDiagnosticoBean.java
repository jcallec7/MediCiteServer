package vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import modelo.Consulta;
import modelo.Diagnostico;
import modelo.Receta;
import negocio.GestionDiagnosticoLocal;
import negocio.GestionRecetaLocal;

@ManagedBean
@SessionScoped
public class GestionDiagnosticoBean {
	
	@Inject
	private GestionDiagnosticoLocal gdl;
	
	@Inject
	private GestionRecetaLocal grl;
	
	/* Beans properties */
	private int id;
	private String detalle;
	private Receta receta;
	private String tipo;
	
	private List<Diagnostico> diagnosticos;
	private List<Receta> recetas;
	
	private String filtro;
	private int selectedDiagnosticoId;
	private int selectedDiagnosticoId2;
	private Receta selectedReceta;
	private Diagnostico selectedDiagnostico; 
	
	@PostConstruct
	public void init() {
		listRecetas();
		listDiagnosticos();
	}

	
	public GestionDiagnosticoLocal getGdl() {
		return gdl;
	}


	public void setGdl(GestionDiagnosticoLocal gdl) {
		this.gdl = gdl;
	}


	public GestionRecetaLocal getGrl() {
		return grl;
	}


	public void setGrl(GestionRecetaLocal grl) {
		this.grl = grl;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	public Receta getReceta() {
		return receta;
	}


	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public List<Diagnostico> getDiagnosticos() {
		return diagnosticos;
	}


	public void setDiagnosticos(List<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
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


	public Receta getSelectedReceta() {
		return selectedReceta;
	}


	public void setSelectedReceta(Receta selectedReceta) {
		this.selectedReceta = selectedReceta;
	}
	
	

	
	public int getSelectedDiagnosticoId() {
		return selectedDiagnosticoId;
	}


	public void setSelectedDiagnosticoId(int selectedDiagnosticoId) {
		this.selectedDiagnosticoId = selectedDiagnosticoId;
	}


	public int getSelectedDiagnosticoId2() {
		return selectedDiagnosticoId2;
	}


	public void setSelectedDiagnosticoId2(int selectedDiagnosticoId2) {
		this.selectedDiagnosticoId2 = selectedDiagnosticoId2;
	}


	public Diagnostico getSelectedDiagnostico() {
		return selectedDiagnostico;
	}


	public void setSelectedDiagnostico(Diagnostico selectedDiagnostico) {
		this.selectedDiagnostico = selectedDiagnostico;
	}

	
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String guardarDiagnostico() {
		System.out.println(selectedReceta);
		gdl.guardarDiagnostico(id, detalle, selectedReceta, tipo);
		diagnosticos = gdl.getDiagnosticos();
		return "listDiagnostico"; 
	}
	
	public List<Diagnostico> buscarDiagnostico() {
		diagnosticos = gdl.getDiagnosticosPorId(filtro);
		return diagnosticos;
	}
	
	public String editDiagnosticoById() {

		gdl.getDiagnosticos();
		selectedDiagnosticoId = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedDiagnosticoId"));
		System.out.println(selectedDiagnosticoId);
		selectedDiagnostico = gdl.readDiagnostico(selectedDiagnosticoId);
		return "updateDiagnostico";
	}
	
	public String deleteDiagnostico() {

		selectedDiagnosticoId2 = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedDiagnosticoId2"));
		System.out.println(selectedDiagnosticoId2);
		gdl.deleteDiagnostico(selectedDiagnosticoId2); 
		return "return alert('Diagnostico Eliminado Exitosamente')";

	}


	private void listDiagnosticos() {
		this.diagnosticos = this.gdl.getDiagnosticos();
	}

	private void listRecetas() {
		this.recetas = this.grl.getRecetas();
	}
	
	public String updateDiagnostico() {
		gdl.updateDiagnostico(id, detalle, receta, tipo);
		return "listDiagnostico";
	}

}
