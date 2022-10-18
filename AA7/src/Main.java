import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
	public static void main(String []args) throws ParseException 
	{
		
		
		try {
			//1º URL -> Likns específicos para las Apis.
			URL url = new URL ("https://api.open-meteo.com/v1/forecast?timezone=Europe/Madrid&latitude=52.52&longitude=13.41&daily=weathercode&current_weather=true");
			
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
			else {
				//6ºTomar la información
				StringBuilder informacionEnString = new StringBuilder();
				//Es una clase que permite crear objetos que Almacenen cadenas de caracteres que 
				//pueden ser modificadas sin necesitar crear nuevos objetos.
				
				Scanner sc = new Scanner(url.openStream());

				
				while (sc.hasNext()) 
				{
					
					informacionEnString.append(sc.nextLine());
						
				}
				sc.close();
				//Acaba paso 6ª
				JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(informacionEnString.toString());

				JSONObject data = (JSONObject) data_obj.get("current_weather");
								
				String cadena = "weathercode:" + data.get("weathercode").toString()
						+ ",temperature:"+ data.get("temperature").toString()
						+",windspeed:"+ data.get("windspeed").toString()
						+",time"+ data.get("time").toString()
						+",winddirection"+ data.get("winddirection").toString();
				System.out.println(cadena);
				
				String codigo_jenkins = "pipeline \r\n"
						+ "{\r\n"
						+ "    agent any\r\n"
						+ "    stages \r\n"
						+ "    {\r\n"
						+ "    stage('Build')\r\n"
						+ "    {\r\n"
						+ "        steps\r\n"
						+ "        {\r\n"
						+ "            println(" +'"'+ cadena +'"'+  ") "
						+ "        }\r\n"
						+ "    }\r\n"
						+ "    }\r\n"
						+ "}";
				
				
				System.out.println(codigo_jenkins);
				String nombreArchivo = "Jenkins";
				Path archivo = Paths.get(nombreArchivo);
				
				List<String> lista = new ArrayList<>();
				lista.add(codigo_jenkins);
				Files.write(archivo, lista, StandardCharsets.UTF_8);
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
