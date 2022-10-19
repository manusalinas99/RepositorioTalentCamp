package AOP;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect //Le indica a Java que esta clase es el aspecto a ejecutar
		// A posterior o antes de la (s) acciones
@Component //Como vamos a ejecutarlo, y que es una clase 
		   // Candidata a tener metodos ejecutables

public class AOP 
{
	@Before("execution(* ganancia(float))")
	public void log1()
	{
		System.out.println("Calculando ganancia");
	}
	@Before("execution(* pasajeros(float))")
	public void log2()
	{
		System.out.println("Calculando pasajeros");
	}
	@Before("execution(* emitirResumen(float,float,float,float,float))")
	public void log3()
	{
		System.out.println("Emitiendo txt de resumen de pasajeros y ganancias");
	}
	
}
