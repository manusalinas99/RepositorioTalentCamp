package Usuario;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Interfaz_Usuario{

	String nombre;
	String password;
	String email;

	
	public void generarUsuario(ArrayList<Usuario> usuarios) {
		
		String nombreArchivo = "usuarios.txt";
		Path archivo = Paths.get(nombreArchivo);
		

		List<String> lista = new ArrayList<>();
		
	
		for(int i=0; i<usuarios.size();i++) {
			
			lista.add( "Nombre" + usuarios.get(i).nombre + "\t" 
					+ "password: "+ usuarios.get(i).password + "\t\t" 
					+ "email: " + usuarios.get(i).email + "\t");
			
		}
	
		try {
			Files.write(archivo, lista, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
