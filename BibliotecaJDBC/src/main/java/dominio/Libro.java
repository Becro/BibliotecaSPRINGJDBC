package dominio;

import java.util.ArrayList;

public class Libro {

	private int idLibro;
	private String isbn,nombre,editorial;
	private Autor autor;
	ArrayList<Prestamo> prestamos;
	
	
	
	public Libro() {}
public Libro(int idLibro, String isbn, String nombre, String editorial, Autor autor, ArrayList<Prestamo>prestamos) {
		
		this.idLibro=idLibro;
		this.isbn=isbn;
		this.nombre=nombre;
		this.editorial=editorial;
		this.autor=autor;
		this.prestamos=prestamos;
		
		}
	
	public Libro(int idLibro, String isbn, String nombre, String editorial, Autor autor) {
		
		this.idLibro=idLibro;
		this.isbn=isbn;
		this.nombre=nombre;
		this.editorial=editorial;
		this.autor=autor;
		
		
		}
	
	public Libro(String isbn, String nombre, String editorial, Autor autor,ArrayList<Prestamo>prestamos) {
		
	
		this.isbn=isbn;
		this.nombre=nombre;
		this.editorial=editorial;
		this.autor=autor;
		this.prestamos=prestamos;
		
	}
public Libro(String isbn, String nombre, String editorial, Autor autor) {
		
		
		this.isbn=isbn;
		this.nombre=nombre;
		this.editorial=editorial;
		this.autor=autor;
		
		
		}
	
	
	
	public int getIdLibro() {
		return idLibro;
	}






	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}






	public String getIsbn() {
		return isbn;
	}






	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}






	public String getNombre() {
		return nombre;
	}






	public void setNombre(String nombre) {
		this.nombre = nombre;
	}






	public String getEditorial() {
		return editorial;
	}






	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}






	public Autor getAutor() {
		return autor;
	}






	public void setAutor(Autor autor) {
		this.autor = autor;
	}






	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(ArrayList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public String toString() {
		return "Libro [idLibro=" + idLibro + ", isbn=" + isbn + ", nombre=" + nombre + ", editorial=" + editorial
				+ ", autor=" + autor + "]";
	}
	
	
	
	
	
	
}
