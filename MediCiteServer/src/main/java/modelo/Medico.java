package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Medico {

	@Id
	@Column(name="mc_med_id")
	private int id;
	
	@Column(name="mc_med_nombre")
	private String nombre;
	
	@Column(name="mc_med_apellido")
	private String apellido;
	
	@Column(name="mc_med_genero")
	private String genero;
	
	@Column(name="mc_med_especialidad")
	private String especialidad;
	
	@Column(name="mc_med_correo")
	private String correo;
	
	@Column(name="mc_med_direccion")
	private String direccion;
	
	@Column(name="mc_med_fechaNac")
	private String fechaNac;	

	
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



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getGenero() {
		return genero;
	}

	


	public void setGenero(String genero) {
		this.genero = genero;
	}



	public String getEspecialidad() {
		return especialidad;
	}



	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}




	public String getFechaNac() {
		return fechaNac;
	}



	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}



	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero
				+ ", correo=" + correo + ", direccion=" + direccion + ", fechaNac=" + fechaNac + "]";
	}
	
	
}
