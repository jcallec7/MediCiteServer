package servicios;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.Usuario;
import negocio.GestionUsuarioLocal;

@WebService
public class UsuariosServiceSoap {

	@Inject
	private GestionUsuarioLocal gpl;
	
	@WebMethod
	public Respuesta crearUsuario(Usuario usuario) {
		
		Respuesta respuesta = new Respuesta();
		try {
			gpl.guardarUsuario(usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getGenero(), usuario.getFecha_nac(), usuario.getCorreo(), usuario.getContrasena(), usuario.getTelf1(), usuario.getTelf2(), usuario.getDireccion(), usuario.getPeso(), usuario.getEstatura(), usuario.getRol());
			respuesta.setCodigo(1);
			respuesta.setMensaje("AL PELOO");
		} catch(Exception e) {
			respuesta.setCodigo(99);
			respuesta.setMensaje("ERROR ALV");
		}
		
		return respuesta;	
	}
	
	@WebMethod
	public List<Usuario> listadoUsuarios() {
		return gpl.getUsuarios();
	}
	
	
}
