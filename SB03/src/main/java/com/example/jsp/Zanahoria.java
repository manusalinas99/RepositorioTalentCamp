package com.example.jsp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Zanahoria implements Interfaz_Zanahoria{

	private String receta;

	public Zanahoria() {
		this.receta = "Ensalada de zanahoria";
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}
	@Override
	public void generarArchivo() {
		
		String nombreArchivo = "recetaZanahoria.txt";
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
