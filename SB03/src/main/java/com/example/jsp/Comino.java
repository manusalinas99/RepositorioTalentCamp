package com.example.jsp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Comino implements Interfaz_Comino{
	private String receta;
	private String nombre;
	private String color;
	private String sabor;
	private int valor;
	
	public Comino() {
		this.receta = "Ensalada de comino";
		this.nombre = "comino";
		this.color = "marron";
		this.sabor = "Rico";
		this.valor = 12;
	}
	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}
	
	@Override
	public void generarArchivo() {
		
		String nombreArchivo = "recetaComino.txt";
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
