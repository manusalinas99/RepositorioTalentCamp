package Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class Controlador {

	@GetMapping("/index")
	public String retornoMapping() {
		
		return "index";
	}
	
	@GetMapping("/Noticias")
	public String otra() {
		
		return "noticias";
	}
	@GetMapping("/imagenes")
	public String retornoImagenes() {
		
		return "imagenes";
	}
	@GetMapping("/Mercado")
	public String retornoMercado() {
		
		return "mercado";
	}
	@GetMapping("/tiempo")
	public String retornoTiempo() {
		
		return "tiempo";
	}

	@GetMapping("/amor")
	public String retornoAmor() {
		
		return "amor";
	}
	@GetMapping("/tiempo")
	public String retornotiempo() {
		
		return "tiempo";
	}
	
}
