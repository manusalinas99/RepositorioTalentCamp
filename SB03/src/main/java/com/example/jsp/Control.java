package com.example.jsp;

import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class Control 
{

	@RequestMapping(value="/index", method = RequestMethod.GET)
	  public void index() {

	        
	 }
	@RequestMapping(value="/generarArchivo", method = RequestMethod.GET)
	   public String generarArchivoTexto(@RequestParam("ingrediente") String nombre) {
		System.out.println(nombre);
		switch(nombre){
		case "zanahoria":	
			Zanahoria zanahoria = new Zanahoria(); 
			zanahoria.generarArchivo();
			break; 
		case "palta":
			Palta palta = new Palta(); 
			palta.generarArchivo();
			break; 
		case "cebolla":
			Cebolla cebolla = new Cebolla(); 
			cebolla.generarArchivo();
			break; 
		case "comino":
			Comino comino = new Comino(); 
			comino.generarArchivo();
			break; 
		case "todo":
			Todo todo = new Todo(); 
			todo.generarArchivo();
			break; 
		}
		
		return "index";
	
	}
	 @RequestMapping(value="/comida", method = RequestMethod.GET)
	   public String generarArchivo() {
		
		
	       return "comida"; 
	 }	
	
	
}
