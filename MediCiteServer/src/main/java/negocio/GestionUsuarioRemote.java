package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import modelo.Usuario;
import modelo.Rol;

@Remote	
public interface GestionUsuarioRemote {
	
	public void guardarUsuario(String id, String nombre, String apellido, String genero, 
								Date fecha_nac, String correo, String especialidad, String contrasena, String telf1, 
								String telf2, String direccion, String peso, String estatura, Rol rol);
	
	public List<Usuario> getUsuarios();

}
