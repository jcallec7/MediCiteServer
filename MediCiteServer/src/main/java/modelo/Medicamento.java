package modelo;

import java.util.List;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Medicamento implements Serializable{
	
	private static final long serialVersionUID = -20336965027624681L;
	
	
	@Id
	@Column(name="mc_medic_id")
	private int id;
	
	@Column(name="mc_medic_nombre")
	private String nombre;
	
	@Column(name="mc_medic_concentr")
	private String concentracion;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getnombre() {
		return nombre;
	}
	public void setnombre(String nombre) {
		this.nombre = nombre;
	}
	public String getConcentracion() {
		return concentracion;
	}
	public void setConcentracion(String concentracion) {
		this.concentracion = concentracion;
	}
	

	@Override
	public String toString() {
		return "Nombre=" + nombre + ", Concentracion=" + concentracion+ "";
	}
	
	
}
