package main;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dominio.*;
import modelo.*;

public class PrincipalBiblioteca {

	public static void main(String[] args) {
		
		//Los DAO
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		ClienteDao clienteDao=(ClienteDao) context.getBean("clienteDAO");
		EmpleadoDao empleadoDao=(EmpleadoDao)context.getBean("empleadoDAO");
		LibroDao libroDao=(LibroDao)context.getBean("libroDAO");
		AutorDao autorDao=(AutorDao)context.getBean("autorDAO");
		PrestamoDao prestamoDao=(PrestamoDao)context.getBean("prestamoDAO");
		
	
		
		//Empleados
		
		Empleado empleado1= new Empleado("47852369F","Pepe","Matinez Ruiperez","+34639852147","correoPepe@gmail.com");
		Empleado empleado2= new Empleado("87412596D","Susana","Pedroche Garcia","+34123456789","susana@gmail.com");
		System.out.println("Alta de empleados");
		empleadoDao.alta(empleado1);
		empleadoDao.alta(empleado2);
		
		//Autores
		
		Autor autor1=new Autor("Gustavo","Adolfo Bécquer","Romanticismo");
		Autor autor2= new Autor("Federico","García Lorca","Generación del 27");
		Autor autor3= new Autor("Miguel","Hernandez","Generación del 27");
		System.out.println("Alta de autores");
		autorDao.alta(autor1);
		autorDao.alta(autor2);
		autorDao.alta(autor3);
		
		//Clientes
		
		Cliente cliente1= new Cliente("47185296E","Adrian","Rodriguez Corbalan","635214785","correo@gmail.com");
		Cliente cliente2= new Cliente("96325874A","Juan Manuel","Lorente Peris","741852963","correo@outlook.com");
		Cliente cliente3= new Cliente("74125836R","Ahinoa","Martinez Lopez","789654123","micorreo@gmail.com");
		System.out.println("Alta de clientes");
		clienteDao.alta(cliente1);
		clienteDao.alta(cliente2);
		clienteDao.alta(cliente3);
		
	
		Autor autor=autorDao.consulta(1);
		Libro libro1= new Libro("12-4569-456-1","Rimas","anaya",autor);
		Libro libro2=new Libro("12-5569-456-1","Leyendas","anaya",autor);
		Libro libro3= new Libro("45-6325-123-4","El libro de los gorriones","anaya",autor);
		Libro libro4= new Libro("45-3625-123-6","Perito en Lunas","planeta",autor);
		System.out.println("Alta de libros");
		libroDao.alta(libro1);libroDao.alta(libro2); libroDao.alta(libro3);libroDao.alta(libro4);
		
		
		System.out.println("Consultas de empleados,clientes y libros");
		ArrayList<Empleado>empleados= empleadoDao.consulta();
		ArrayList<Cliente>clientes=clienteDao.consulta();
		ArrayList<Libro>libros=libroDao.consulta();
		
		System.out.println("COMPLETADO");
		System.out.println("Vemos las listas");
		System.out.println("LIBROS");
		for(Libro l:libros)System.out.println(l.toString());
		System.out.println("CLIENTES");
		for(Cliente c:clientes)System.out.println(c.toString());
		System.out.println("EMPLEADOS");
		for(Empleado e:empleados)System.out.println(e.toString());
		System.out.println("Realizamos prestamo");
		
		GregorianCalendar fechaInicio= new GregorianCalendar();
		GregorianCalendar fechaFin= new GregorianCalendar();
		fechaFin.set(2020, 9, 15);
		Prestamo pres1= new Prestamo(empleados.get(0),clientes.get(0),libros.get(0),fechaInicio,fechaFin);
		Prestamo pres2= new Prestamo(empleados.get(0),clientes.get(0),libros.get(1),fechaInicio,fechaFin);
		Prestamo pres3= new Prestamo(empleados.get(0),clientes.get(0),libros.get(2),fechaInicio,fechaFin);
		Prestamo pres4= new Prestamo(empleados.get(1),clientes.get(1),libros.get(3),fechaInicio,fechaFin);
		Prestamo pres5= new Prestamo(empleados.get(1),clientes.get(1),libros.get(3),fechaInicio,fechaFin);
		System.out.println("Alta de prestamos");
		prestamoDao.alta(pres1);prestamoDao.alta(pres2);prestamoDao.alta(pres3);prestamoDao.alta(pres4);prestamoDao.alta(pres5);
		
		
		System.out.println("Consulta de clientes");
		clientes=clienteDao.consulta();
		for(Cliente c:clientes) {
				c.toString();
				System.out.println("Lista de prestamos al cliente " +c.getNombre());
				for(Prestamo p:c.getPrestamos())
				{
					System.out.println(p.toString());
				}
			
		}
		

	}

}
