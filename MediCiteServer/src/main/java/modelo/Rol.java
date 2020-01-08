package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rol {
	
	private static final long serialVersionUID = -6594217200682507286L;
	
	@Id
	@Column(name="mc_rol_id")
	private int id;
	
	@Column(name="mc_rol_descripcion")
	private String descripcion;

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
	
	
	

}
