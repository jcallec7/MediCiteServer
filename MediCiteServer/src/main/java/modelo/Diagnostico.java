package modelo;

public class Diagnostico {
	
	private int id;
	private String detalle;
	private Receta receta;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public Receta getReceta() {
		return receta;
	}
	public void setReceta(Receta receta) {
		this.receta = receta;
	}
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Diagnostico [id=" + id + ", detalle=" + detalle + ", receta=" + receta + "]";
	}
	
	
	
	
	
	
	
	

}
