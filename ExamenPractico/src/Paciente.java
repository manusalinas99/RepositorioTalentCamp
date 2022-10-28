import java.time.Period;

public class Paciente extends Persona implements Interfaz_Paciente{

	String enfermedad;
	String medicina;
	String valor;
	String seguro;
	String esperanza;
	String cobrar;
	String valorFinal;
	int id;
	
	public Paciente(String nombre, String fecha_nac, String enfermedad, String medicina, String valor,
			String seguro, int id) {
		super(nombre, fecha_nac);
		this.enfermedad = enfermedad;
		this.medicina = medicina;
		this.valor = valor;
		this.seguro = seguro;
		this.id = id;

	}

	public void calcularEsperanza() {
		
		if(this.edad.getYears() >= 30 && this.enfermedad.compareTo("Alergia") == 0) {
			
			this.esperanza = "baja";
		}else if(this.edad.getYears() >= 30 && this.enfermedad.compareTo("Alergia") != 0) {
			
			this.esperanza = "media";
		}else if(this.edad.getYears() < 30 && this.enfermedad.compareTo("Rosacea") == 0) {
			
			this.esperanza = "media";
		}else if(this.edad.getYears() >= 30 && this.enfermedad.compareTo("Alergia") != 0) {
			
			this.esperanza = "alta";
		}
			
			
		
	}

	public void calcularSeguro() {
		
		if(this.seguro.compareTo("No posee") == 0) {
			
			this.cobrar = "No cobrar recargo";
			this.valorFinal = this.valor;
			
		}else if(this.seguro.compareTo("Swiss Medical") == 0) {
			
			this.cobrar = "Cobrar un recargo de 5%";
			Double vf = Integer.parseInt(this.valor) + Integer.parseInt(this.valor)*0.05;
			this.valorFinal = vf.toString();
			
		}else if(this.seguro.compareTo("Assist Card") == 0) {
			
			this.cobrar = "Cobrar un recargo de 10%";
			Double vf = Integer.parseInt(this.valor) + Integer.parseInt(this.valor)*0.10;
			this.valorFinal = vf.toString();
		}
		
	}
}

