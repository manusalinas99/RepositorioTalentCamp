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
	@GetMapping("/Tecnología")
	public String retornoTecnologia() {
		
		return "tecnologías";
	}
	@GetMapping("/Mercado")
	public String retornoMercado() {
		
		return "mercado";
	}
	@GetMapping("/Comida")
	public String retornoComida() {
		
		return "Comida";
	}
	@GetMapping("/Farandula")
	public String retornoFarandula() {
		
		return "Farandula";
	}
	@GetMapping("/Deportes")
	public String retornoDeportes() {
		
		return "Deportes";
	}
	@GetMapping("/Gaming")
	public String retornoGaming() {
		
		return "Gaming";
	}
	@GetMapping("/Influencers")
	public String retornoInfluencers() {
		
		return "Influencers";
	}
	@GetMapping("/Musica")
	public String retornoMusica() {
		
		return "Musica";
	}
	
}
