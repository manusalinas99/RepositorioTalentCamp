package AOP;

public class Aerolinea implements Interfaz_Aerolinea{

	String nombre;
	float num_pasajes_total;
	float ganancia_total = 0;
	public Aerolinea(String nombre) {
		this.nombre = nombre;
	}

	public void añadirGanancia(float ganancia_parcial) {
		this.ganancia_total += ganancia_parcial;
		
	}

}
