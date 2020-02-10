package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

import datos.ConsultaDAO;
import datos.DiagnosticoDAO;
import datos.FacturaDAO;
import datos.UsuarioDAO;
import modelo.Consulta;
import modelo.Diagnostico;
import modelo.Factura;
import modelo.Usuario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Date;

@Stateless
public class GestionFactura implements GestionFacturaLocal, GestionFacturaRemote {
	
	@Inject
	private FacturaDAO dao;

	@Inject
	private ConsultaDAO daoConsulta;
	
	@Inject
	private UsuarioDAO daoUsuario;
	
	@Inject
	private DiagnosticoDAO daoDiagnostico;

	private List<Factura> factura = new ArrayList<Factura>();
	
	private Document documento = new Document();

	public void guardarFactura(int id, String nombre, String cedulaRuc, String direccion, Consulta consulta, double subtotal, double total, Date fecha) {

		Factura f = new Factura();
		f.setId(id);
		f.setNombre(nombre);
		f.setCedulaRuc(cedulaRuc);
		f.setDireccion(direccion);
		f.setConsulta(consulta);
		f.setSubtotal(subtotal);
		f.setTotal(total);
		f.setFecha(fecha);
		System.out.println(f);
		dao.insert(f);
	}

	public void eliminarFactura(int id) {
		System.err.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/ FACTURA ELIMINADA /*/*/*/*/*/*/*/*/*//**/");
		dao.remove(id);
	}

	public void modificarFactura(int id, String nombre, String cedulaRuc, String direccion, Consulta consulta, double subtotal, double total, Date fecha) {

		Factura f = new Factura();
		f.setId(id);
		f.setNombre(nombre);
		f.setCedulaRuc(cedulaRuc);
		f.setDireccion(direccion);
		f.setConsulta(consulta);
		f.setSubtotal(subtotal);
		f.setTotal(total);
		f.setFecha(fecha);
		System.out.println(f);
		dao.update(f);
	}

	public Factura leerFactura(int id) {
		Factura facturas = dao.read(id);

		List<Consulta> consultas = daoConsulta.getConsultas();
		List<Usuario> pacientes = daoUsuario.getUsuarioPorRol(4);
		List<Usuario> medicos = daoUsuario.getUsuarioPorRol(3);		
		List<Diagnostico> diagnosticos = daoDiagnostico.getDiagnostico();
		return facturas;
	}

	public List<Factura> getFactura() {
		System.out.println(factura);
		List<Consulta> consultas = daoConsulta.getConsultas();
		List<Usuario> pacientes = daoUsuario.getUsuarioPorRol(4);
		List<Usuario> medicos = daoUsuario.getUsuarioPorRol(3);		
		return dao.getFactura();
	}

	public List<Factura> getFacturasPorId(String filtro) {
		daoConsulta.getConsultas();
		return dao.getFacturasXId(filtro);
	}

	public void generatePDF(Factura factura) {
		
		try {
        	String path = new File(".").getCanonicalPath();
        	String FILE_NAME = path + "/factura" + (dao.getFactura().size() + 1 ) + ".pdf";
        	
            PdfWriter.getInstance(documento, new FileOutputStream(new File(FILE_NAME)));
 
            documento.open();
 
            Paragraph paragraphHello = new Paragraph();
            paragraphHello.add("MediCite Factura # " + (dao.getFactura().size() + 1 )
            					+ "\n Nombre: " + factura.getNombre()
            					+ "\n Cedula/RUC: " + factura.getCedulaRuc()
            					+ "\n Direccion: " + factura.getDireccion());
            paragraphHello.setAlignment(Element.ALIGN_CENTER);
 
            documento.add(paragraphHello);
 
            Paragraph paragraphLorem = new Paragraph();
            paragraphLorem.add(
            		"\n 1 Consulta: "
            		+ "\n Medico: " + factura.getConsulta().getMedico().getNombre() + " " + factura.getConsulta().getMedico().getApellido() + ", " + factura.getConsulta().getMedico().getEspecialidad()
            		+ "\n Paciente: " + factura.getConsulta().getUsuario().getNombre() + " " + factura.getConsulta().getUsuario().getApellido() + ", " + factura.getConsulta().getUsuario().getId()
            		+ "\n Fecha: " + factura.getConsulta().getFecha());
            
            java.util.List<Element> paragraphList = new ArrayList<>();
            
            paragraphList = paragraphLorem.breakUp();
 
            Font f = new Font();
            f.setFamily(FontFamily.COURIER.name());
            f.setStyle(Font.BOLDITALIC);
            f.setSize(18);
            
            Paragraph p3 = new Paragraph();
            p3.setFont(f);
            p3.setAlignment(Element.ALIGN_RIGHT);
            p3.addAll(paragraphList);
            p3.add("\n Subtotal: " + factura.getSubtotal()
            		+ "\n IVA(12%): " + (factura.getTotal() - factura.getSubtotal())
            		+ "\n Total: " + factura.getTotal());
 
            documento.add(paragraphLorem);
            documento.add(p3);
            documento.close();
 
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
