package modelo;

import java.util.ArrayList;

import dominio.Autor;

public interface AutorInterface {

	public boolean alta(Autor autor);
	public boolean baja(int idAutor);
	public boolean modificacion(Autor autor);
	public Autor consulta(int idAutor);
	public ArrayList<Autor> consulta();
	
}
