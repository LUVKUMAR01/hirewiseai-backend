package com.hirewise_ai.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;


@Configuration
public class SwaggerConfig {

	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("HireWise AI API")
                        .version("1.0"))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
    }

    // 🔐 AUTH GROUP
    @Bean
    public GroupedOpenApi authApi() {
        return GroupedOpenApi.builder()
                .group("🔐 Auth APIs")
                .pathsToMatch("/auth/**")
                .build();
    }

    // 📄 RESUME GROUP
    @Bean
    public GroupedOpenApi resumeApi() {
        return GroupedOpenApi.builder()
                .group("📄 Resume APIs")
                .pathsToMatch("/resume/**")
                .build();
    }

    // 🎤 INTERVIEW GROUP
    @Bean
    public GroupedOpenApi interviewApi() {
        return GroupedOpenApi.builder()
                .group("🎤 Interview APIs")
                .pathsToMatch("/mock-interview/**", "/interview/**")
                .build();
    }

    // 🧠 ANALYSIS GROUP (if exists)
    @Bean
    public GroupedOpenApi analysisApi() {
        return GroupedOpenApi.builder()
                .group("🧠 Analysis APIs")
                .pathsToMatch("/analysis/**")
                .build();
    }    
    
    
}