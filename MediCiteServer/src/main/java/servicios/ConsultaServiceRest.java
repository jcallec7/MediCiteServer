package servicios;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import modelo.Consulta;
import negocio.GestionConsultaLocal;

@Path("/consultas")

public class ConsultaServiceRest {
	
	@Inject
	private GestionConsultaLocal gcl;
	
	@GET
	@Path("/listar")
	@Produces("application/json")
	
	public List<Consulta> getConsultas() {
		
		
		
		return gcl.getConsultas();
		
	}

}
