import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Persona implements Interfaz_Persona{

	String nombre;
	String fecha_nac;
	Period edad;
	public Persona(String nombre, String fecha_nac) {
		this.nombre = nombre;
		this.fecha_nac = fecha_nac;
	}
	@Override
	public void calcularEdad() {
		LocalDate fecha = LocalDate.now(); 
		DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate nac = LocalDate.parse(this.fecha_nac, JEFormatter);
		Period periodo = Period.between(nac,fecha);
		this.edad = periodo;
		
	}
}
