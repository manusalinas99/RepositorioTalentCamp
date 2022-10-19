package AOP;

public class Vuelo {

	//atributos de la clase vuelo
	String turno;
	String ciudad;
	float ganancia_neta;
	float pasajeros;
	float pasajes;
	//CONSTRUCTOR
	public Vuelo(String ciudad, float pasajeros, String turno,float ganancia,float pasajes) {
		this.ciudad = ciudad;
		this.pasajeros = pasajeros;
		this.turno = turno;
		this.ganancia_neta = ganancia;
		this.pasajes = pasajes;
	}
	//Devuelve un string con todos los datos
	public String imprimirDatos() {
		
		return ("Ciudad: "+ this.ciudad +"\n"
				+ "Turno: "+ this.turno +"\n"
				+ "Pasajes vendidos: " +this.pasajes +"\n"
				+ "Pasajeros: "+this.pasajeros +"\n"
				+ "Ganancias netas: "+ this.ganancia_neta + "€\n");
		
	}
	
}
