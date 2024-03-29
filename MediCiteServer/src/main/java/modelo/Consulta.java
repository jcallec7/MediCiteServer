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
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Consulta implements Serializable {

	private static final long serialVersionUID = -6594217200682507286L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "mc_cons_id")
	private int id;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "mc_pa_id")
	private Usuario usuario;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "mc_med_id")
	private Usuario medico;

	@Column(name = "mc_cons_estado")
	private String estado;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "mc_cons_fecha")
	private Date fecha;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "mc_diag_id")
	private Diagnostico diagnostico;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getMedico() {
		return medico;
	}

	public void setMedico(Usuario medico) {
		this.medico = medico;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}

	@Override
	public String toString() {
		return "Consulta [id=" + id + ", usuario=" + usuario + ", medico=" + medico + ", estado=" + estado + ", fecha="
				+ fecha + ", diagnostico=" + diagnostico + "]";
	}
	
}
