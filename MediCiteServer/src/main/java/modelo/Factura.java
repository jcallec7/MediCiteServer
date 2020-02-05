package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Factura implements Serializable {

	private static final long serialVersionUID = -292628179707140384L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mc_fact_id")
	private int id;

	@Column(name = "mc_fact_nombre")
	private String nombre;

	@Column(name = "mc_fact_cedruc")
	private String cedulaRuc;

	@Column(name = "mc_fact_direccion")
	private String direccion;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "mc_cons_id")
	private Consulta consulta;

	@Column(name = "mc_fact_subtotal")
	private double subtotal;

	@Column(name = "mc_fact_total")
	private double total;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "mc_fact_date")

	private Date fecha;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedulaRuc() {
		return cedulaRuc;
	}

	public void setCedulaRuc(String cedulaRuc) {
		this.cedulaRuc = cedulaRuc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", nombre=" + nombre + ", cedulaRuc=" + cedulaRuc + ", direccion=" + direccion
				+ ", consulta=" + consulta + ", subtotal=" + subtotal + ", total=" + total + ", fecha=" + fecha + "]";
	}

}