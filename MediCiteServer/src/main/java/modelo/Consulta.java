package modelo;

import java.io.Serializable;
//import java.sql.Time;
import java.util.Date;
//import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	private Paciente paciente;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "mc_med_id")
	private Medico medico;

	@Temporal(TemporalType.DATE)
	@Column(name = "mc_cons_fecha")
	private Date fecha;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mc_diag_id")
	private Diagnostico diagnostico;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Consulta [id=" + id + ", paciente=" + paciente + ", medico=" + medico + ", fecha=" + fecha
				+ ", diagnostico=" + diagnostico + "]";
	}

}
