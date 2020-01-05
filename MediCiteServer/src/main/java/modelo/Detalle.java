package modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Detalle implements Serializable {
	
	private static final long serialVersionUID = -20336965027624681L;

	@Id
	@Column(name="mc_det_id")
	private String id;
	
	@Column(name="mc_det_nombre")
	private String nombre;
	
	@ManyToOne()
	private Medicamento medicamento;

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

	
	@Override
	public String toString() {
		return "Detalle [id=" + id + ", nombre=" + nombre + ", medicamento=" + medicamento + "]";
	}
	
}
