package com.example.testApp.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Test bank app",
                description = "Bank", version = "1.0.0",
                contact = @Contact(
                        name = "Ankudinov Danila"
                )
        )
)
public class SwaggerConfig {

}
