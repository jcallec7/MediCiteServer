package modelo;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.*;

@Entity
public class Consulta implements Serializable

{
	private static final long serialVersionUID = -6594217200682507286L;
	
	@Id
	@Column(name="mc_cons_ID")
	private int id;
	
	
	@JoinColumn(name = "mc_cons_paciente")
	private Paciente paciente;
	
	
	
	@JoinColumn(name = "mc_cons_medico")
	private Medico medico;
	
	@Column(name="mc_cons_fecha")
	private Date fecha;
	
	@Column(name="mc_cons_hora")
	private Time hora;
	
	
	@JoinColumn(name = "mc_cons_diagnostico")
	private Diagnostico diagnostico;

	@Override
	public String toString() {
		return "Consulta [id=" + id + ", paciente=" + paciente + ", medico=" + medico + ", fecha=" + fecha + ", hora="
				+ hora + ", diagnostico=" + diagnostico + "]";
	}
	
	
	
}
