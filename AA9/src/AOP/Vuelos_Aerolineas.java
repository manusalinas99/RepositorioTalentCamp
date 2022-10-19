package AOP;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Vuelos_Aerolineas {

	public static void main(String []args) {
	AnnotationConfigApplicationContext pa = new AnnotationConfigApplicationContext(ConfiguracionAOP.class);
	Servicio servicio = pa.getBean(Servicio.class);
	
	Aerolinea iberia = new Aerolinea("iberia");
	
	File doc1 = new File("C:\\Users\\msalinasp\\eclipse-workspace\\AA9\\src\\Barcelona.txt");
	File doc2 = new File("C:\\\\Users\\\\msalinasp\\\\eclipse-workspace\\\\AA9\\\\src\\\\Berlin.txt");
	File doc3 = new File("C:\\\\Users\\\\msalinasp\\\\eclipse-workspace\\\\AA9\\\\src\\\\Buenos Aires.txt");
	File doc4 = new File("C:\\\\Users\\\\msalinasp\\\\eclipse-workspace\\\\AA9\\\\src\\\\Madrid.txt");
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
	
	Vuelo Barcelona = new Vuelo(ciudad,servicio.pasajeros(pas),turno,servicio.ganancia(pas));	
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
	
	Vuelo Berlin = new Vuelo(ciudad,servicio.pasajeros(pas),turno,servicio.ganancia(pas));	
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
	
	Vuelo Buenos_Aires = new Vuelo(ciudad,servicio.pasajeros(pas),turno,servicio.ganancia(pas));	
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
	
	
	Vuelo Madrid = new Vuelo(ciudad,servicio.pasajeros(pas),turno,servicio.ganancia(pas));	
	sc.close();
	
	iberia.añadirGanancia(Barcelona.ganancia_neta);
	iberia.añadirGanancia(Buenos_Aires.ganancia_neta);
	iberia.añadirGanancia(Berlin.ganancia_neta);
	iberia.añadirGanancia(Madrid.ganancia_neta);
	
	servicio.emitirResumen(iberia.ganancia_total, Barcelona.pasajeros,Berlin.pasajeros,Madrid.pasajeros,Buenos_Aires.pasajeros);
	pa.close();
	}
}
