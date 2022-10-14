package AOP;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Principal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext ca = new AnnotationConfigApplicationContext(ConfiguradorAOP.class);
		Servicio servicio = ca.getBean(Servicio.class);
		servicio.elTiempo();

	}

}
