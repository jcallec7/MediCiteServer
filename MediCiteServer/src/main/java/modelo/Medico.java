package modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Medico {

	@Id
	@Size(min=10, max=13)
	@Column(name="mc_med_id")
	private String id;
	
	@Column(name="mc_med_nombre")
	private String nombre;
	
	@Column(name="mc_med_apellido")
	private String apellido;
	
	@Column(name="mc_med_genero")
	private String genero;
	
	@Column(name="mc_med_especialidad")
	private String especialidad;
	
	@Email
	@Column(name="mc_med_correo")
	private String correo;
	
	@Column(name="mc_med_direccion")
	private String direccion;
	
	@Temporal(TemporalType.DATE)
	@Column(name="mc_med_fechaNac")
	private Date fechaNac;
	
	@Column(name="mc_med_contrasena")
	private String contrasena;

	
	


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




	public Date getFechaNac() {
		return fechaNac;
	}



	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}



	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	@Override
	public String toString() {
		return "Medico [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero
				+ ", correo=" + correo + ", direccion=" + direccion + ", fechaNac=" + fechaNac + "]";
	}
	
	
}
