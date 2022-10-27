package com.example.jsp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Cebolla implements Interfaz_Cebolla{

	private String receta;
	private String nombre;
	private String color;
	private String sabor;
	private int valor;
	
	public Cebolla() {
		this.receta = "Ensalada de cebolla";
		this.nombre = "Cebolla";
		this.color = "Blanca";
		this.sabor = "Rico";
		this.valor = 10;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	@Override
	public void generarArchivo() {
		
		String nombreArchivo = "recetaCebolla.txt";
		Path archivo = Paths.get(nombreArchivo);
		

		List<String> lista = new ArrayList<>();
			
			lista.add( "Receta \t " + this.receta);
	
	
		try {
			Files.write(archivo, lista, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
