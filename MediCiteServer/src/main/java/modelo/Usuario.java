package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6594217200682507286L;

	
	@Id
	@Size(min=10, max=13)
	@Column(name="mc_usr_id")
	private String id;
	
	@Column(name="mc_usr_nombre")
	private String nombre;
	
	@Column(name="mc_usr_apellido")
	private String apellido;
	
	@Column(name="mc_usr_genero")
	private String genero;
	
	@Temporal(TemporalType.DATE)
	@Column(name="mc_usr_fecha_nac")
	private Date fecha_nac;
	
	@Email
	@Column(name="mc_usr_correo")
	private String correo;
	
	@Column(name="mc_usr_especialidad")
	private String especialidad;
	
	@Column(name="mc_usr_contraseña")
	private String contrasena;
	
	@Column(name="mc_usr_telf1")
	private String telf1;
	
	@Column(name="mc_usr_telf2")
	private String telf2;
	
	@Column(name="mc_usr_direccion")
	private String direccion;
	
	@Column(name="mc_usr_peso")
	private String peso;
	
	@Column(name="mc_usr_estatura")
	private String estatura;
	
	@ManyToOne
	@JoinColumn(name="mc_usr_rol")
	private Rol rol;

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
	
	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getTelf1() {
		return telf1;
	}

	public void setTelf1(String telf1) {
		this.telf1 = telf1;
	}

	public String getTelf2() {
		return telf2;
	}

	public void setTelf2(String telf2) {
		this.telf2 = telf2;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getEstatura() {
		return estatura;
	}

	public void setEstatura(String estatura) {
		this.estatura = estatura;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return " Paciente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero + ", fecha_nac=" + fecha_nac + ", correo=" + correo + ", contrasena="
				+ contrasena + ", telf1=" + telf1 + ", telf2=" + telf2 + ", direccion=" + direccion + ", peso=" + peso
				+ ", estatura=" + estatura + "]";
	}
	
}
