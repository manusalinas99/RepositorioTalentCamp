import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String [] args) {
	
		File doc = new File("C:\\Users\\msalinasp\\eclipse-workspace\\ExamenPractico\\src\\empresa.txt");
	
		Scanner sc = null;
		try {
			sc = new Scanner(doc);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Paciente> conjunto = new ArrayList<Paciente>();
		String linea = "";
		String[] parte;
		int id = 1;
		linea = sc.nextLine();
		linea = sc.nextLine();
		parte = linea.split("\t");

		Paciente paciente = new Paciente(parte[0],parte[1],parte[2],parte[3],parte[4],parte[5],id);
		paciente.calcularEdad();
		paciente.calcularEsperanza();
		paciente.calcularSeguro();
	
		conjunto.add(paciente);
		int l = 0;
		int meter = 1;
		
		while (sc.hasNextLine()){
			l = 0;
			meter = 1;
			linea = sc.nextLine();
			parte = linea.split("\t");

			while (l < conjunto.size()) {
				
			
				if(conjunto.get(l).nombre.compareTo(parte[0]) == 0) {
					meter = 0;
				}
				l++;
			}
			
			if (meter != 0) {
				id++;
				Paciente paciente1 = new Paciente(parte[0],parte[1],parte[2],parte[3],parte[4],parte[5],id);
				paciente1.calcularEdad();
				paciente1.calcularEsperanza();
				paciente1.calcularSeguro();
				
				conjunto.add(paciente1);
			}
		}

			String nombreArchivo = "pacientesEstado.txt";
			Path archivo = Paths.get(nombreArchivo);
			

			List<String> lista = new ArrayList<>();
			int z = 0;
			lista.add("ID\tNombre\tFecha Nacimiento\tEdad\tEnfermedad\tValor Medicina\tSeguro Médico\tEsperanza\tRecargo\tValor Final Medicina");
			while(z < conjunto.size()) {
				
				lista.add(conjunto.get(z).id +"\t" +
						conjunto.get(z).nombre +"\t" +
						conjunto.get(z).fecha_nac +"\t" +
						conjunto.get(z).edad.getYears() +"\t" +
						conjunto.get(z).enfermedad +"\t" +
						conjunto.get(z).valor +"\t" +
						conjunto.get(z).seguro +"\t" +
						conjunto.get(z).esperanza +"\t" +
						conjunto.get(z).cobrar +"\t" +
						conjunto.get(z).valorFinal +"\t" );
				z++;
			}
		
			try {
				Files.write(archivo, lista, StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			System.out.println("Final");
		
		
	}	
}
