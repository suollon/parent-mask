package com.lingdong.common.model.global_config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

/**
 * @description swagger 相关配置
 * http://ip:port/swagger-ui/index.html
 */
@Configuration
public class SwaggerConfig {

    @Value("${spring.profiles.active}")
    private String env;

    @Bean
    public Docket frontAdminDoc() {
        return new Docket(DocumentationType.OAS_30)
                .enable(!"prod".equals(env))
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lingdong.front.admin"))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(securityContext())
                .securitySchemes(securitySchemes());
    }

    // @Bean
    // public Docket frontAppDoc() {
    //     return new Docket(DocumentationType.OAS_30)
    //             .enable(!"prod".equals(env))
    //             .apiInfo(apiInfo())
    //             .select()
    //             .apis(RequestHandlerSelectors.basePackage("com.lingdong.front.app"))
    //             .paths(PathSelectors.any())
    //             .build()
    //             .securityContexts(securityContext())
    //             .securitySchemes(securitySchemes());
    // }

    private List<SecurityScheme> securitySchemes() {
        return Collections.singletonList(new ApiKey("token", HttpHeaders.AUTHORIZATION, "header"));
    }

    private List<SecurityContext> securityContext() {
        SecurityContext securityContext = SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
        return Collections.singletonList(securityContext);
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(new SecurityReference("JWT", authorizationScopes));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("mask-front-admin")
                .build();
    }
}


