package dominio;

import java.util.GregorianCalendar;

public class Prestamo {

	private int idPrestamo;
	private Empleado empleado;
	private Cliente cliente;
	private Libro libro;
	private GregorianCalendar fechaInicio, fechaFin;
	
	
	public Prestamo() {}
	
	public Prestamo(int idPrestamo, Empleado empleado,Cliente cliente, Libro libro, GregorianCalendar fechaInicio,GregorianCalendar fechaFin) {
		
		this.idPrestamo=idPrestamo;
		this.empleado=empleado;
		this.cliente=cliente;
		this.libro=libro;
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		
		
	}
	
public Prestamo(Empleado empleado,Cliente cliente, Libro libro, GregorianCalendar fechaInicio,GregorianCalendar fechaFin) {
		
		
		this.empleado=empleado;
		this.cliente=cliente;
		this.libro=libro;
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		
		
	}



	public int getIdPrestamo() {
		return idPrestamo;
	}
	
	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}
	
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Libro getLibro() {
		return libro;
	}
	
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	public GregorianCalendar getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(GregorianCalendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public GregorianCalendar getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(GregorianCalendar fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	@Override
	public String toString() {
		return "Prestamo [idPrestamo=" + idPrestamo + ", empleado=" + empleado + ", cliente=" + cliente + ", libro=" + libro
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
	
	

	
}
