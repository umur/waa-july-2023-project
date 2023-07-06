package waa.miu.AlumniManagementPortal.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    public static final String SEC_SCHEME_NAME = "ApiKey";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes(SEC_SCHEME_NAME,
                                new SecurityScheme().type(SecurityScheme.Type.APIKEY)
                                        .in(SecurityScheme.In.HEADER)
                                        .name("Authorization"))
                )
                .info(new Info().title("Group 007's WAA AlumniProject API").version("1.0")
                        .contact(contact())
                        .description(
                                "Alumni Project using springdoc-openapi."));
    }

    private Contact contact() {
        Contact contact = new Contact();
        contact.setName("Fortune King");
        contact.setEmail("");
        return contact;
    }

}
