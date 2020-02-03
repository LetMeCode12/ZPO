package ProjektAPI.ProjektAPI;

import ProjektAPI.ProjektAPI.seciurity.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean(){

		FilterRegistrationBean filterRegistrationBean =new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new JwtFilter());
		filterRegistrationBean.setUrlPatterns(Collections.singleton("/api/*"));
		return filterRegistrationBean;
	}
}

/**
 * Api uruchamiamy w tej klasie.
 * Aby uruchomić front należy przejść do folderu uiapp i w terminalu wpisać polecenie "npm run serve"
 */