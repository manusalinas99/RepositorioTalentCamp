package AOP;
import java.io.IOException;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Servicio AOP con los métodos que calcula la ganancia y el num de pasajeros dependiendo 
//del num de pasajes vendidos.
@Service
public class Servicio 
{
	public float ganancia(float pas) {
		
		return pas*50;
	}
	public float pasajeros(float pas) {
		
		return pas/2;
		
	}
	
	
}