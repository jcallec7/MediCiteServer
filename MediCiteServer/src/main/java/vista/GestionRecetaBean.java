package vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import datos.RecetaDAO;
import modelo.Medicamento;
import modelo.Receta;
import negocio.GestionMedicamentoLocal;
import negocio.GestionRecetaLocal;



@ManagedBean
public class GestionRecetaBean {

	
	@Inject
	private GestionRecetaLocal grl;
	
	private RecetaDAO dao;
	private int id;
	private String descr;

	private List<Receta> recetas;
	
	private String filtro;
	private int selectedRecetaId;
	private int selectedRecetaId2;


	
	@PostConstruct
	public void init() {
		listReceta();
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

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
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

	
	
	
	
	public String guardarReceta() {
		grl.guardarReceta(id, descr);
		recetas = grl.getReceta();
	
		//return "listadoAutores";
		return null;
	}
	
	
	public List<Receta> buscarReceta() {
		
		recetas = grl.getRecetasPorNombre(filtro); 
		
		return null;
	}
	
	public String editarReceta() {
		
		
		grl.editarReceta(id, descr);
		//System.out.print(id+"," +nombre+"," +apellido+"," +genero+"," +especialidad+"," + correo+"," +direccion+"," +fechaNac+"," +contrasena);
		recetas = grl.getReceta();
		
		
		//return "listadoAutores";
		return null;
	}
	
	public String deleteReceta() {
		
		selectedRecetaId2 = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectRecetaId2"));
		System.out.println(selectedRecetaId2);
		grl.delateReceta(selectedRecetaId2);
		return null;
		
	}
	

	
	private void listReceta() {
		this.recetas = this.grl.getReceta();
		
	}
	
}
