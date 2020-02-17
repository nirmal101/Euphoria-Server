package lk.ac.cmb.ucsc.euphoria;

import lk.ac.cmb.ucsc.euphoria.util.ActiveUsersUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EuphoriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EuphoriaApplication.class, args);
	}
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/getCounselors").allowedOrigins("http://localhost:3000");
//			}
//		};
//	}
	@Bean
	public ActiveUsersUtil activeUsersStore(){
		return new ActiveUsersUtil();
	}

}
