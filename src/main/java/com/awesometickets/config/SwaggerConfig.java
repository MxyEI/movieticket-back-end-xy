package com.awesometickets.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = {"com.awesometickets.web.controller"})
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("xy movie")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.awesometickets.web.controller")) // 注意修改此处的包名
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("影票系统 API测试")
                .description("影票系统 RESTful APIs")
                .termsOfServiceUrl("http://btorg.org/")
                .contact("xy")
                .version("1.0.0")
                .build();
    }
}