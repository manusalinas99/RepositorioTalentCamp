package AOP;

public class Aerolinea implements Interfaz_Aerolinea{

	//ATRIBUTOS
	String nombre;
	float ganancia_total = 0;
	public Aerolinea(String nombre) {
		this.nombre = nombre;
	}
	//Clase imprementada de la interfaz que calcula la ganancia total
	public void añadirGanancia(float ganancia_parcial) {
		this.ganancia_total += ganancia_parcial;
		
	}

}
