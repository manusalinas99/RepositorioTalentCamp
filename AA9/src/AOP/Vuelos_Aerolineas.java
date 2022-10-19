//AUTOR: Manuel Salinas Porras 

package AOP;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Vuelos_Aerolineas {

	
	public static void main(String []args) {
	
	//Activa el servicio	
	AnnotationConfigApplicationContext pa = new AnnotationConfigApplicationContext(ConfiguracionAOP.class);
	Servicio servicio = pa.getBean(Servicio.class);
	
	//Crea la clase Aerolínea
	Aerolinea iberia = new Aerolinea("iberia");
	
	//Inicialización de apertura de los ficheros y su lectura
	File doc1 = new File("C:\\Users\\msalinasp\\git\\repository2\\AA9\\src\\Barcelona.txt");
	File doc2 = new File("C:\\\\Users\\\\msalinasp\\\\git\\\\repository2\\\\AA9\\\\src\\\\Berlin.txt");
	File doc3 = new File("C:\\\\Users\\\\msalinasp\\\\git\\\\repository2\\\\AA9\\\\src\\\\Buenos Aires.txt");
	File doc4 = new File("C:\\\\Users\\\\msalinasp\\\\git\\\\repository2\\\\AA9\\\\src\\\\Madrid.txt");
	Scanner sc = null;
	try {
		sc = new Scanner(doc1);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	String linea = "";
	linea = sc.nextLine();
	String ciudad = linea;
	linea = sc.nextLine();
	String dato = linea.substring((linea.indexOf(":")+2));
	float pas = Integer.parseInt(dato);
	linea = sc.nextLine();
	String turno = linea.substring(linea.indexOf(":")+1);
	
	Vuelo Barcelona = new Vuelo(ciudad,servicio.pasajeros(pas),turno,servicio.ganancia(pas),pas);	
	sc.close();
	
	try {
		sc = new Scanner(doc2);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	linea = "";
	linea = sc.nextLine();
	ciudad = linea;
	linea = sc.nextLine();
	dato = linea.substring(linea.indexOf(":")+2);
	pas = Integer.parseInt(dato);
	linea = sc.nextLine();
	turno = linea.substring(linea.indexOf(":")+1);
	
	Vuelo Berlin = new Vuelo(ciudad,servicio.pasajeros(pas),turno,servicio.ganancia(pas),pas);	
	sc.close();
	
	try {
		sc = new Scanner(doc3);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	linea = "";
	linea = sc.nextLine();
	ciudad = linea;
	linea = sc.nextLine();
	dato = linea.substring(linea.indexOf(":")+2);
	pas = Integer.parseInt(dato);
	linea = sc.nextLine();
	turno = linea.substring(linea.indexOf(":")+1);
	
	Vuelo Buenos_Aires = new Vuelo(ciudad,servicio.pasajeros(pas),turno,servicio.ganancia(pas),pas);	
	sc.close();
	
	try {
		sc = new Scanner(doc4);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	linea = "";
	linea = sc.nextLine();
	ciudad = linea;
	linea = sc.nextLine();
	dato = linea.substring(linea.indexOf(":")+2);
	pas = Integer.parseInt(dato);
	linea = sc.nextLine();
	turno = linea.substring(linea.indexOf(":")+1);
	
	
	Vuelo Madrid = new Vuelo(ciudad,servicio.pasajeros(pas),turno,servicio.ganancia(pas),pas);	
	sc.close();
	
	//Añadir las ganancias de cada vuelo y calcula el total
	iberia.añadirGanancia(Barcelona.ganancia_neta);
	iberia.añadirGanancia(Buenos_Aires.ganancia_neta);
	iberia.añadirGanancia(Berlin.ganancia_neta);
	iberia.añadirGanancia(Madrid.ganancia_neta);

	//Imprime todos los datos en el txt de salida
	List<String> vuelo = new ArrayList<String>(); 
	
	vuelo.add("Compañía: " + iberia.nombre +"\n");
	vuelo.add(Barcelona.imprimirDatos());
	vuelo.add(Buenos_Aires.imprimirDatos());
	vuelo.add(Berlin.imprimirDatos());
	vuelo.add(Madrid.imprimirDatos());
	vuelo.add("Ganancias Totales = "+ iberia.ganancia_total +"€");
	
	  LocalDate date = LocalDate.now();
	
	 String nombreArchivo = "resumenVentas_" + date.getMonth() + date.getYear() + ".txt";
	 Path archivo = Paths.get(nombreArchivo);
	  
	try {
		Files.write(archivo, vuelo, StandardCharsets.UTF_8);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	pa.close();
	}
	
}

