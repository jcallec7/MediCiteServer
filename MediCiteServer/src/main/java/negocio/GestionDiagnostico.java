package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.DiagnosticoDAO;
import modelo.Diagnostico;
import modelo.Receta;

@Stateless
public class GestionDiagnostico implements GestionDiagnosticoLocal, GestionDiagnosticoRemote
{
	@Inject
	private DiagnosticoDAO dao;

	private List<Diagnostico> diagnosticos = new ArrayList<Diagnostico>();
	
	@Override
	public void guardarDiagnostico(int id, String detalle, Receta receta) {
		Diagnostico d = new Diagnostico();
		d.setID(id);
		d.setDetalle(detalle);
		d.setReceta(receta);
		System.out.println(d);

		diagnosticos.add(d);
		dao.insert(d);
	}

	@Override
	public List<Diagnostico> getDiagnostico() {
		System.out.println(diagnosticos);
		return dao.getDiagnostico();
	}

	@Override
	public List<Diagnostico> getDiagnosticoPorNombre(int filtro) {
		return dao.getDiagnosticoXId(filtro);
	}

	@Override
	public void deleteDiagnostico(int id) {
		dao.remove(id);
	}

}
