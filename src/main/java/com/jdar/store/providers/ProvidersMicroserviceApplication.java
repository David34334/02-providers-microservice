package com.jdar.store.providers;

import com.jdar.store.exceptions.configuration.ExceptionHandlerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({
		ExceptionHandlerConfiguration.class
})
@SpringBootApplication
public class ProvidersMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvidersMicroserviceApplication.class, args);
	}

}
