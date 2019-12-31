package net.friend.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocumentationConfig {
  ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("eco-api")
        .description("API for eCommerce")
        .license("Apache 2.0")
        .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
        .termsOfServiceUrl("https://edumall.vn/terms")
        .version("1.0.33")
        .contact(new Contact("QUANBH2", "", "quanbh2@topica.edu.vn"))
        .build();
  }

  @Bean
  public Docket customImplementation() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("net.friend.controller"))
        .build()
        .apiInfo(apiInfo());
  }
}
