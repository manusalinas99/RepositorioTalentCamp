package AOP;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect //Le indica a Java que esta clase es el aspecto a ejecutar
		// A posterior o antes de la (s) acciones
@Component //Como vamos a ejecutarlo, y que es una clase 
		   // Candidata a tener metodos ejecutables

public class AOP 
{
	@Before("execution(* elTiempo())")
	public void log()
	{
		//Formato de fecha
	  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd");  
      LocalDateTime now = LocalDateTime.now();
      System.out.println("El día actual es: "+ dtf.format(now));

	}
	@Around("execution(* elTiempo())")
	public Object  log1(ProceedingJoinPoint pjp) throws Throwable
	{
		System.out.println("ANTES");
		Object valorRetorno = pjp.proceed();
		System.out.println("La hora de ejecución es: " + LocalTime.now());
		return valorRetorno;
		
	}
	

}

