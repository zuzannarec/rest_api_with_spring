package rest.java.restApi.swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).
                groupName("ailleron-api").
                apiInfo(apiInfo()).select().build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Warsztaty").
                description("costam").termsOfServiceUrl("www.ailleron.pl").
                license("a").version("1").build();
    }
}
