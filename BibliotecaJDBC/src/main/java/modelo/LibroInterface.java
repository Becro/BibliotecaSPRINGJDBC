package modelo;

import java.util.ArrayList;

import dominio.Libro;

public interface LibroInterface {

	public boolean alta(Libro libro);
	public boolean baja(int idLibro);
	public boolean modificacion(Libro libro);
	public Libro consulta(int idLibro);
	public ArrayList<Libro>consulta();
	
}
