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

@Service
public class Servicio 
{
	public float ganancia(float pas) {
		
		return pas*50;
	}
	public float pasajeros(float pas) {
		
		return pas/2;
		
	}
	public void emitirResumen(float ganancia, float pasajerosBarc,float pasajerosBer,float pasajerosBue,float pasajerosMad) {
				
		 List<String> vuelo = new ArrayList(); 
		 vuelo.add("Pasajeros Barcelona:" + pasajerosBarc);
		 vuelo.add("Pasajeros Berlín:" + pasajerosBer);
		 vuelo.add("Pasajeros Madrid:" + pasajerosMad);
		 vuelo.add("Pasajeros Buenos Aires:" + pasajerosBue);
		 vuelo.add("Ganancias totales son:" + ganancia + "€");
		 
		 
		 String nombreArchivo = "resumenVentas_" + LocalDate.now() + ".txt";
	 	 Path archivo = Paths.get(nombreArchivo);
		  
	 	try {
			Files.write(archivo, vuelo, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	}
	
}