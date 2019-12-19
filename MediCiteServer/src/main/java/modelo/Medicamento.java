package modelo;

public class Medicamento {
	
	
	private int id;
	private String nombreMed;
	private String concentracion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreMed() {
		return nombreMed;
	}
	public void setNombreMed(String nombreMed) {
		this.nombreMed = nombreMed;
	}
	public String getConcentracion() {
		return concentracion;
	}
	public void setConcentracion(String concentracion) {
		this.concentracion = concentracion;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Medicamento [id=" + id + ", nombreMed=" + nombreMed + ", concentracion=" + concentracion + "]";
	}
	
	
	
	
	
	

}
