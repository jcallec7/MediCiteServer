package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Receta implements Serializable{
	
	
	private static final long serialVersionUID = -6594217200682507286L;
	
	/**
	 * 
	 */
	
	@Id
	@Column(name="mc_rec_id")
	private int mc_rec_id;
	
	
	@Column(name="mc_rec_descr")
	private String mc_rec_descr;
	
	
	
	
	
	
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "mc_medic_id")
	private List<Medicamento> mc_medicamentos;


	public int getMc_rec_id() {
		return mc_rec_id;
	}


	public void setMc_rec_id(int mc_rec_id) {
		this.mc_rec_id = mc_rec_id;
	}


	public String getMc_rec_descr() {
		return mc_rec_descr;
	}


	public void setMc_rec_descr(String mc_rec_descr) {
		this.mc_rec_descr = mc_rec_descr;
	}


	public List<Medicamento> getMc_medicamentos() {
		return mc_medicamentos;
	}


	public void setMc_medicamentos(List<Medicamento> mc_medicamentos) {
		this.mc_medicamentos = mc_medicamentos;
	}


	@Override
	public String toString() {
		return "Receta [mc_rec_id=" + mc_rec_id + ", mc_rec_descr=" + mc_rec_descr + "]";
	}

}
