package AOP;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.springframework.stereotype.Service;
@Service
public class Servicio 
{
	public void elTiempo() throws IOException 
	{
		
		URL url = new URL ("https://www.el-tiempo.net/api/json/v2/provincias/08/municipios/08019");
		
		//2º Declarar una Conexión
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();	
		
		//3º Declarar método de acción
		conn.setRequestMethod("GET");//Voy a obtener información, por eso el GET.
		//4º Conectar la conexión
		conn.connect(); //Me conecto EFECTIVAMENTE a la URL de la API.
		//5º Declarar tiempo de respuesta, obtener tiempo de respuesta.
		int codigoRespuesta = conn.getResponseCode(); //Devuelve del lado de la API si me pude conectar
		
		if(codigoRespuesta != 200) //200 es conexión satisfactoria
		{
			throw new RuntimeException("Respuesta de error" + codigoRespuesta);
			
		}
		Scanner scB = new Scanner(url.openStream());
		
		while(scB.hasNextLine()) {
		System.out.println(scB.nextLine());
		}
		
	}
	
	
	
}
	
