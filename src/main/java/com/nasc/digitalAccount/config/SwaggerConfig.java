package com.nasc.digitalAccount.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
//@EnableSwagger2
public class SwaggerConfig {
//    public static final Contact DEFAULT_CONTACT = new Contact("Diego Merjildo", "https://github.com/merjildo", "diego.merjildo@gmail.com");
//    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Digital Account API",
//            "Digital Account API",
//            "1.0", "urn:tos",
//            DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", Arrays.asList());
    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(Arrays.asList("application/json", "application/xml"));

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO)
//                .produces(DEFAULT_PRODUCES_AND_CONSUMES).consumes(DEFAULT_PRODUCES_AND_CONSUMES);
//    }
@Bean
public OpenAPI springShopOpenAPI() {
    return new OpenAPI()
            .info(new Info().title("Digital Account API")
                    .description("Digital Account API")
                    .version("v0.0.1")
                    .license(new License().name("Apache 2.0").url("http://springdoc.org")))
            .externalDocs(new ExternalDocumentation()
                    .description("Diego F. Merjildo")
                    .url("https://github.com/merjildo"));
}
}
