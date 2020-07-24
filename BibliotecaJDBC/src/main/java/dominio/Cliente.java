package dominio;

import java.util.ArrayList;

public class Cliente {

	private int idCliente;
	private String dni,nombre,apellidos,telefono,correo;
	private ArrayList<Prestamo>prestamos;
	
	
	public Cliente() {}
	public Cliente(int idCliente,String dni, String nombre, String apellidos, String telefono, String correo,ArrayList<Prestamo>prestamos) {
		
		this.idCliente=idCliente;
		this.dni=dni;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.telefono=telefono;
		this.correo=correo;
		this.prestamos=prestamos;
		
		}
public Cliente(int idCliente,String dni, String nombre, String apellidos, String telefono, String correo) {
		
		this.idCliente=idCliente;
		this.dni=dni;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.telefono=telefono;
		this.correo=correo;
		
		
		}
public Cliente(String dni, String nombre, String apellidos, String telefono, String correo,ArrayList<Prestamo>prestamos) {
		
		
		this.dni=dni;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.telefono=telefono;
		this.correo=correo;
		this.prestamos=prestamos;
		
		}
	
public Cliente(String dni, String nombre, String apellidos, String telefono, String correo) {
	
	
	this.dni=dni;
	this.nombre=nombre;
	this.apellidos=apellidos;
	this.telefono=telefono;
	this.correo=correo;
	
	
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}
	public void setPrestamos(ArrayList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", telefono=" + telefono + ", correo=" + correo + ", prestamos=" + prestamos + "]";
	}
	
	
	
	
	
}
