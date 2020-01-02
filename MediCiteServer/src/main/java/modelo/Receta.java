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
	private int id;
	
	@Column(name="mc_rec_descr")
	private String descr;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	@Override
	public String toString() {
		return "Receta [id=" + id + ", descr=" + descr + "]";
	}
	
	
	
	

}
