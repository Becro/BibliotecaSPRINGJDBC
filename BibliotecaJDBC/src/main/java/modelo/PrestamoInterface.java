package modelo;

import java.util.ArrayList;

import dominio.Prestamo;

public interface PrestamoInterface {

	public boolean alta(Prestamo prestamo);
	public boolean baja(int idPrestamo);
	public boolean modificacion(Prestamo prestamo);
	public Prestamo consulta(int idPrestamo);
	public ArrayList<Prestamo>consulta();
	
}
