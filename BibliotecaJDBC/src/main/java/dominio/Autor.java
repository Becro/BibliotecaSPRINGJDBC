package dominio;

import java.util.ArrayList;

public class Autor {
	
	private int idAutor;
	private String nombre, apellidos, periodo;
	private ArrayList<Libro>libros;
	
	public Autor() {}
	public Autor(int idAutor, String nombre,String apellidos, String periodo,ArrayList<Libro>libros) {
		
		this.idAutor=idAutor;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.periodo=periodo;
		this.libros=libros;
			
	}
public Autor(int idAutor, String nombre,String apellidos, String periodo) {
		
		this.idAutor=idAutor;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.periodo=periodo;
		
			
	}
	
public Autor(String nombre,String apellidos, String periodo,ArrayList<Libro>libros) {
		
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.periodo=periodo;
		this.libros=libros;
			
	}
public Autor(String nombre,String apellidos, String periodo) {
	
	this.nombre=nombre;
	this.apellidos=apellidos;
	this.periodo=periodo;
	
		
}
public int getIdAutor() {
	return idAutor;
}
public void setIdAutor(int idAutor) {
	this.idAutor = idAutor;
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
public String getPeriodo() {
	return periodo;
}
public void setPeriodo(String periodo) {
	this.periodo = periodo;
}
public ArrayList<Libro> getLibros() {
	return libros;
}
public void setLibros(ArrayList<Libro> libros) {
	this.libros = libros;
}
@Override
public String toString() {
	return "Autor [idAutor=" + idAutor + ", nombre=" + nombre + ", apellidos=" + apellidos + ", periodo=" + periodo
			+ ", libros=" + libros + "]";
}

	
	

}
