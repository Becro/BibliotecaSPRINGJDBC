package modelo;

import java.util.ArrayList;

import dominio.Empleado;

public interface EmpleadoInterface {

	public boolean alta(Empleado empleado);
	public boolean baja(int idEmpleado);
	public boolean modificacion(Empleado empleado);
	public Empleado consulta(int idEmpleado);
	public ArrayList<Empleado>consulta();
}
