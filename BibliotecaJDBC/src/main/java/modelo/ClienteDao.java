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


public class ClienteDao implements ClienteInterface {
	
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate template) {this.jdbcTemplate=template;}

	public boolean alta(Cliente cliente) {
	
		try {
			String alta="Insert into TCliente values(null,?,?,?,?,?);";
			this.jdbcTemplate.update(alta, cliente.getDni(),cliente.getNombre(),cliente.getApellidos(),cliente.getTelefono(),cliente.getCorreo());
			return true;
		}catch(DataAccessException ex) {ex.printStackTrace();}
		
		return false;
	}

	public boolean baja(int idCliente) {
try {
			String baja="Delete from TCliente where idCliente=?;";
			this.jdbcTemplate.update(baja,idCliente);
			baja="Delete from tPrestamo where idCliente=?";
			this.jdbcTemplate.update(baja,idCliente);
			
			return true;
		}catch(DataAccessException ex) {ex.printStackTrace();}
		return false;
	}

	public boolean modificacion(Cliente cliente) {
try {
			String modificacion="Update TCliente set dni=?, nombre=?,apellidos=?,telefono=?, correo=? where idCliente=?;";
			this.jdbcTemplate.update(modificacion, cliente.getDni(),cliente.getNombre(),cliente.getApellidos(),cliente.getTelefono(),cliente.getCorreo(),cliente.getIdCliente());
			return true;
			
		}catch(DataAccessException ex) {ex.printStackTrace();}
		return false;
	}

	public Cliente consulta(int idCliente) {
try {	
		String consulta="Select * from TCliente where idCliente=?;";
		Cliente cliente=this.jdbcTemplate.queryForObject(consulta, new ClienteMapper(),idCliente);
		consulta="Select * from tPrestamo where idCliente=?;";
		ArrayList<Prestamo>prestamos=(ArrayList) this.jdbcTemplate.query(consulta,new PrestamoMapper(),idCliente);
			cliente.setPrestamos(prestamos);
			return cliente;
		}catch(DataAccessException ex) {ex.printStackTrace();}
		return null;
	}

	public ArrayList<Cliente> consulta() {
try {
			String consulta="Select * from Tcliente;";
			ArrayList<Cliente>clientes=(ArrayList)this.jdbcTemplate.query(consulta, new ClienteMapper());
			for(Cliente c:clientes) {
				
				consulta="Select * from TPrestamo where idCliente=?;";
				ArrayList<Prestamo>prestamos=(ArrayList) this.jdbcTemplate.query(consulta,new PrestamoMapper(),c.getIdCliente());
				c.setPrestamos(prestamos);
				
			}
			return clientes;
	
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
