package org.sketch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Classe que inicia o servidor. Beans importantes podem figurar aqui. 
 * 
 * @author Eri Jonhson
 */
@SpringBootApplication(scanBasePackages={"org.sketch"})
public class SpringSketchApplication {

	/**
	 * Bean para cadastrar credenciais de clientes autorizados a requisitarem
	 * serviços deste RESTful Web Server.
	 * 
	 * @return filtro para CORS
	 */
	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*"); // qualquer cliente HTTP pode requisitar serviços
		config.addAllowedOrigin("http://localhost:8000"); // exemplo de como especificar um cliente
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSketchApplication.class, args);
	}

}
