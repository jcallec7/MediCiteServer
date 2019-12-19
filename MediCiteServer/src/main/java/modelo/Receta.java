package modelo;

import java.util.List;


public class Receta {
	
	
	private int id;
	private String descripcion;
	private List<Medicamento> medicamentos;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Receta [id=" + id + ", descripcion=" + descripcion + ", medicamentos=" + medicamentos + "]";
	} 
	
	
	
	
	
	

}
