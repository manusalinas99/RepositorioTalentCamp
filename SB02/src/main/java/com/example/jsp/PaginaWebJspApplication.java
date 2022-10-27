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