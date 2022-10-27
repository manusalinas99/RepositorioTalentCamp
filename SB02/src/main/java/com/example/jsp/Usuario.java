package com.example.jsp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Usuario {

	String nombre;
	String apellido;
	String email;
	String localidad;
	String fecha_nac;
	
	

	public Usuario(String nombre, String apellido, String email, String localidad, String fecha_nac) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.localidad = localidad;
		this.fecha_nac = fecha_nac;
	}



	public void generarUsuario(ArrayList<Usuario> usuarios) {
			
			String nombreArchivo = "loginUsuarios.txt";
			Path archivo = Paths.get(nombreArchivo);
			
	
			List<String> lista = new ArrayList<>();
			
		
			for(int i=0; i<usuarios.size();i++) {
				
				lista.add( "Nombre" + usuarios.get(i).nombre + "\t" 
						+ "apellido: "+ usuarios.get(i).apellido + "\t\t" 
						+ "email: " + usuarios.get(i).email + "\t"
						+ "localidad: "+ usuarios.get(i).localidad + "\t"
						+ "fecha nacimiento: "+ usuarios.get(i).fecha_nac + "\t");
				
			}
		
			try {
				Files.write(archivo, lista, StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
