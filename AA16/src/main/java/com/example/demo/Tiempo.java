package com.example.demo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Tiempo {
	
	public String tiempoEnMalaga() throws IOException {
		String tiempo = "";
		
		URL url = new URL ("https://www.el-tiempo.net/api/json/v1/provincias/28/municipios/28079/weather");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();	

		conn.setRequestMethod("GET");//Voy a obtener información, por eso el GET.
		conn.connect(); //Me conecto EFECTIVAMENTE a la URL de la API.
		int codigoRespuesta = conn.getResponseCode(); //Devuelve del lado de la API si me pude conectar
		
		if(codigoRespuesta != 200) 
		{
			throw new RuntimeException("Respuesta de error" + codigoRespuesta);
			
		}
		else {
			StringBuilder informacionEnString = new StringBuilder();
			Scanner sc = new Scanner(url.openStream());
			while (sc.hasNext()) 
			{	
				informacionEnString.append(sc.nextLine());
			}
			sc.close();
			tiempo = informacionEnString.toString();
		return tiempo;
	
		}
	}
}
	

