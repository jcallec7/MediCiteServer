package vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import modelo.Medicamento;
import modelo.Receta;
import negocio.GestionMedicamentoLocal;
import negocio.GestionRecetaLocal;

@ManagedBean
public class GestionMedicamentoBean {
	
	@Inject
	private GestionMedicamentoLocal gml;
	
	@Inject
	private GestionRecetaLocal grl;
	
	private int id;
	private String nombre;
	private String concentracion;
	private List<Medicamento> medicamentos;
	private String filtro;
	private List<Receta> recetas;
	private SelectItem recetaSeleccionada;

	@PostConstruct
	public void init() {
		this.listarRecetas();
	}
	
	

	public GestionMedicamentoLocal getGml() {
		return gml;
	}

	public void setGml(GestionMedicamentoLocal gml) {
		this.gml = gml;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getConcentracion() {
		return concentracion;
	}

	public void setConcentracion(String concentracion) {
		this.concentracion = concentracion;
	}

	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
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
	
	public SelectItem getRecetaSeleccionada() {
		return recetaSeleccionada;
	}



	public void setRecetaSeleccionada(SelectItem recetaSeleccionada) {
		this.recetaSeleccionada = recetaSeleccionada;
	}

	public String guardarMedicamento() {
		
		gml.guardarMedicamento(id, nombre, concentracion, recetas);
		//System.out.print(id+"," +nombre+"," +apellido+"," +genero+"," +especialidad+"," + correo+"," +direccion+"," +fechaNac+"," +contrasena);
		medicamentos = gml.getMedicamento();
		
		
		//return "listadoAutores";
		return null;
	}
	
	public String buscarMedicamento() {
		
		medicamentos = gml.getMedicamentoPorNombre(filtro);
		
		return null;
	}
	
	
	public void listarRecetas() {
		this.recetas = this.grl.getReceta();
	}
}
