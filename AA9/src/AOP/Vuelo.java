package AOP;

public class Vuelo {

	String turno;
	String ciudad;
	float ganancia_neta;
	float pasajeros;
	public Vuelo(String ciudad, float pasajeros, String turno,float ganancia) {
		this.ciudad = ciudad;
		this.pasajeros = pasajeros;
		this.turno = turno;
		this.ganancia_neta = ganancia;
	}
	
}
