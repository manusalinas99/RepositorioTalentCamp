package com.example.jsp;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PaginaWebJspApplication {

	public static void main(String[] args) throws ParseException, IOException {
		SpringApplication.run(PaginaWebJspApplication.class, args);
	
		Clima clima = new Clima();
		
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
	
        ArrayList<Usuario> usuarios = new ArrayList();
	
        Usuario usuario1 = new Usuario("Pepe","Lopez","plopez@gmail.com","malaga","10/10/1990");
        Usuario usuario2 = new Usuario("Saul","Rodirguez","srodriguez@gmail.com","madrid","10/01/1980");
        Usuario usuario3 = new Usuario("Lorena","Saez","lsaez@gmail.com","barcelona","20/10/1995");
	
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        
        usuario1.generarUsuario(usuarios);
        
	}

}