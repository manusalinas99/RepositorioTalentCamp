package com.example.jsp;

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

@Controller
public class Control 
{

	@RequestMapping(value="/index", method = RequestMethod.GET)
	  public void index() {

	        
	 }
	
	 @RequestMapping(value="/hola", method = RequestMethod.GET)
	  public ModelAndView getHola() {
		 ModelAndView model = new ModelAndView("/hola");
		 	Hola hola = new Hola("");
		 	model.addObject("hola", hola.getTexto());
	        return model;
	        
	 }
	 
	 @RequestMapping(value="/clima", method = RequestMethod.GET)
	  public ModelAndView clima() throws IOException, ParseException {
		 ModelAndView model = new ModelAndView("/clima");
		 	Clima clima = new Clima();
		 	model.addObject("clima", clima.tiempoEnMalaga());
	        return model;
	        
	 }
	 @RequestMapping(value="/deportes", method = RequestMethod.GET)
	  public ModelAndView deportes() {
		 ModelAndView model = new ModelAndView("/deportes");
		 	Deportes deporte = new Deportes("");
		 	model.addObject("deporte", deporte.texto);
	        return model;
	        
	 }
	 @RequestMapping(value="/comida", method = RequestMethod.GET)
	  public ModelAndView comida() {
		 ModelAndView model = new ModelAndView("/comida");
		 Comida comida = new Comida("");
		 	model.addObject("comida", comida.texto);
	        return model;
	        
	 }	
	 @RequestMapping(value="/economia", method = RequestMethod.GET)
	  public ModelAndView economia() {
		 ModelAndView model = new ModelAndView("/economia");
		 	Economia economia = new Economia("");
		 	model.addObject("economia", economia.texto);
	        return model;
	        
	 }	
	 @RequestMapping(value="/noticias", method = RequestMethod.GET)
	  public ModelAndView noticias() {
		 ModelAndView model = new ModelAndView("/noticias");
		 Noticias noticias = new Noticias("");
		 	model.addObject("noticias", noticias.texto);
	        return model;
	        
	 }		
	 @RequestMapping(value="/tecnologia", method = RequestMethod.GET)
	  public ModelAndView tecnologia() {
		 ModelAndView model = new ModelAndView("/tecnologia");
		 Tecnologia tecnologia = new Tecnologia("");
		 	model.addObject("tecnologia", tecnologia.texto);
	        return model;
	        
	 }	
	
	
}
