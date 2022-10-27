package com.example.jsp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Clima {

	
	public String tiempoEnMalaga() throws IOException, ParseException {
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
			
			JSONParser parse = new JSONParser();
	        JSONObject data_obj = (JSONObject) parse.parse(tiempo);
	        data_obj = (JSONObject) data_obj.get("prediccion");
	        JSONArray array = (JSONArray) data_obj.get("dia");
	        
	        JSONObject prediccion = (JSONObject) array.get(0);
	        JSONObject temperatura = (JSONObject) prediccion.get("temperatura");
	        String temp_max = (String) temperatura.get("maxima");
	        int temperatura_max = Integer.parseInt(temp_max);
	        String temp_min = (String) temperatura.get("minima");
	        int temperatura_min = Integer.parseInt(temp_min);
	        
	        String tmp = "temperatura máxima en Málaga: "+ temp_max + "\n temperatura mininma: " + temp_min;
		
		return tmp;
	
		}
	}	
}