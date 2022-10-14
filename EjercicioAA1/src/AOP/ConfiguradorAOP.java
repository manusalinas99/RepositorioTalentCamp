package AOP;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration //Indico que es la clase de configuracion donde esta el Proxy.
@ComponentScan("AOP") //Le indico en que paquete lo puede hacer.
@EnableAspectJAutoProxy //Relacionamiento de las distintas clases entre si.
public class ConfiguradorAOP {

	
	
}
