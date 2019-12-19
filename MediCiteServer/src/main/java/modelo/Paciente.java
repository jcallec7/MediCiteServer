package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Paciente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6594217200682507286L;

	@Id
	@Column(name="mc_pa_id")
	private String id;
	
	@Column(name="mc_pa_nombre")
	private String nombre;
	
	@Column(name="mc_pa_apellido")
	private String apellido;
	
	@Column(name="mc_pa_cedula")
	private String cedula;
	
	@Column(name="mc_pa_genero")
	private String genero;
	
	@Column(name="mc_pa_fecha_nac")
	private String fecha_nac;
	
	@Column(name="mc_pa_correo")
	private String correo;
	
	@Column(name="mc_pa_contraseña")
	private String contrasena;
	
	@Column(name="mc_pa_telf1")
	private String telf1;
	
	@Column(name="mc_pa_telf2")
	private String telf2;
	
	@Column(name="mc_pa_direccion")
	private String direccion;
	
	@Column(name="mc_pa_peso")
	private String peso;
	
	@Column(name="mc_pa_estatura")
	private String estatura;

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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(String fecha_nac) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", genero=" + genero + ", fecha_nac=" + fecha_nac + ", correo=" + correo + ", contrasena="
				+ contrasena + ", telf1=" + telf1 + ", telf2=" + telf2 + ", direccion=" + direccion + ", peso=" + peso
				+ ", estatura=" + estatura + "]";
	}
	
}
