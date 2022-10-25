package com.example.demo;


import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Aa13Application {

	public static void main(String[] args) throws IOException, ParseException {
		SpringApplication.run(Aa13Application.class, args);
		
		Tiempo clima = new Tiempo();
		
		
		JSONParser parse = new JSONParser();
        JSONObject data_obj = (JSONObject) parse.parse(clima.tiempoEnMalaga());
        data_obj = (JSONObject) data_obj.get("prediccion");
        JSONArray array = (JSONArray) data_obj.get("dia");
        
        JSONObject prediccion = (JSONObject) array.get(0);
        JSONObject temperatura = (JSONObject) prediccion.get("temperatura");
        String temp_max = (String) temperatura.get("maxima");
        int temperatura_max = Integer.parseInt(temp_max);
        String temp_min = (String) temperatura.get("minima");
        int temperatura_min = Integer.parseInt(temp_min);
        
        System.out.println("temperatura máxima en Málaga: "+ temp_max + "\n temperatura mininma: " + temp_min);
	}

}
