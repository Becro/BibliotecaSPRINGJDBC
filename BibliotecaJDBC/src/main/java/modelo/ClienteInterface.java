package modelo;

import java.util.ArrayList;

import dominio.Cliente;

public interface ClienteInterface {
	
	public boolean alta(Cliente cliente);
	public boolean baja(int idCliente);
	public boolean modificacion(Cliente cliente);
	public Cliente consulta(int idCliente);
	public ArrayList<Cliente> consulta();
	

}
