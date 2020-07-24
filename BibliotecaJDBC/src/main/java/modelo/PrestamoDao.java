package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dominio.Autor;
import dominio.Cliente;
import dominio.Empleado;
import dominio.Libro;
import dominio.Prestamo;


public class PrestamoDao implements PrestamoInterface {
	
	
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate template) {this.jdbcTemplate=template;}

	public boolean alta(Prestamo prestamo) {
		try {
			String alta="Insert into tPrestamo values (null,?,?,?,?,?);";
			this.jdbcTemplate.update(alta,prestamo.getEmpleado().getIdEmpleado(),prestamo.getCliente().getIdCliente(),prestamo.getLibro().getIdLibro(),prestamo.getFechaInicio(),prestamo.getFechaFin());
			return true;
		}catch(DataAccessException ex) {ex.printStackTrace();}
		return false;
	}

	public boolean baja(int idPrestamo) {
		try {
			String baja="Delete from tPrestamo where idPrestamo=?;";
			this.jdbcTemplate.update(baja,idPrestamo);
			return true;
		}catch(DataAccessException ex) {ex.printStackTrace();}
		return false;
	}

	public boolean modificacion(Prestamo prestamo) {
		try{
			String modificacion="Update tPrestamo set idEmpleado=?,idCliente=?, idLibro=?, fecha_inicio=?,fecha_fin=? where idPrestamo=?";
			this.jdbcTemplate.update(modificacion,prestamo.getEmpleado().getIdEmpleado(),prestamo.getCliente().getIdCliente(),prestamo.getLibro().getIdLibro(),prestamo.getFechaInicio(),prestamo.getFechaFin(), prestamo.getIdPrestamo());
			return true;
			
		}catch(DataAccessException ex) {ex.printStackTrace();}
		return false;
	}

	public Prestamo consulta(int idPrestamo) {
		try {
			String consulta="Select * from TPrestamo where idPrestamo=?";
			return this.jdbcTemplate.queryForObject(consulta, new PrestamoMapper(),idPrestamo);
						
			
		}catch(DataAccessException ex) {ex.printStackTrace();}
		return null;
	}

	public ArrayList<Prestamo> consulta() {
		try {
			String consulta="Select * from TPrestamo;";
			return (ArrayList) this.jdbcTemplate.query(consulta, new PrestamoMapper());
			
		}catch(DataAccessException ex) {ex.printStackTrace();}
		return null;
	}

	
	
	
	
	//MAPPER
	class EmpleadoMapper implements RowMapper<Empleado>{

		public Empleado mapRow(ResultSet rs, int rowNum) throws SQLException {
		
			int idEmpleado= rs.getInt("idEmpleado");
			String dni=rs.getString("dni");
			String nombre=rs.getString("nombre");
			String apellidos= rs.getString("apellidos");
			String telefono=rs.getString("telefono");
			String correo=rs.getString("Correo");
			
			return new Empleado(idEmpleado,dni,nombre,apellidos,telefono,correo);
		}}
	
	class PrestamoMapper implements RowMapper<Prestamo>{

		public Prestamo mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			int idPrestamo=rs.getInt("idPrestamo");
			int idEmpleado=rs.getInt("idEmpleado");
			String consulta="Select * from tEmpleado where idEmpleado=?;";
			Empleado empleado= jdbcTemplate.queryForObject(consulta, new EmpleadoMapper(), idEmpleado);
			int idCliente=rs.getInt("idCliente");
			consulta="Select * from tCliente where idCliente=?;";
			Cliente cliente=jdbcTemplate.queryForObject(consulta, new ClienteMapper(), idCliente);
			int idLibro= rs.getInt("idLibro");
			consulta="Select * from tLibro where idLibro=?";
			Libro libro=jdbcTemplate.queryForObject(consulta, new LibroMapper(), idLibro);
			Date fInicio=rs.getDate("Fecha_inicio");
			GregorianCalendar fechaInicio= new GregorianCalendar();
			fechaInicio.setTime(fInicio);
			fechaInicio.getTimeInMillis();
			Date fFin= rs.getDate("Fecha_fin");
			GregorianCalendar fechaFin= new GregorianCalendar();
			fechaFin.setTime(fFin);
			fechaFin.getTimeInMillis();
			
			return new Prestamo(idPrestamo,empleado,cliente,libro,fechaInicio,fechaFin);
		}}
	
	class ClienteMapper implements RowMapper<Cliente>{

		public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			int idCliente= rs.getInt("idCliente");
			String dni=rs.getString("dni");
			String nombre=rs.getString("nombre");
			String apellidos= rs.getString("apellidos");
			String telefono=rs.getString("telefono");
			String correo=rs.getString("Correo");
			
			return new Cliente(idCliente,dni,nombre,apellidos,telefono,correo);
		}}
	class LibroMapper implements RowMapper<Libro>{

		public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			int idLibro=rs.getInt("idLibro");
			String isbn=rs.getString("isbn");
			String nombre=rs.getString("nombre");
			String editorial=rs.getString("editorial");
			int idAutor= rs.getInt("idAutor");
			String consulta="Select * from tAutor where idAutor=?;";
			Autor autor=jdbcTemplate.queryForObject(consulta, new AutorMapper(),idAutor);
			
			return new Libro(idLibro,isbn,nombre,editorial,autor);
		}}
	
	class AutorMapper implements RowMapper<Autor>{

		public Autor mapRow(ResultSet rs, int rowNum) throws SQLException {
				int idAutor=rs.getInt("idAutor");
				String nombre=rs.getString("nombre");
				String apellidos=rs.getString("apellidos");
				String periodo=rs.getString("periodo");
			
			
			
			return new Autor(idAutor,nombre,apellidos,periodo);
		}}
}
