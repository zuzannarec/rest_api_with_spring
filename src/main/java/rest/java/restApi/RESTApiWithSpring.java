package rest.java.restApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
public class RESTApiWithSpring {

	public static void main(String[] args) {
		SpringApplication.run(RESTApiWithSpring.class, args);
		System.out.println("test.");
	}

	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
	    return builder.build();
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("Messages");
	    return messageSource;
    }
}
