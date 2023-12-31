package com.example.management_backend.configs.knife;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Knife4jConfig {
    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(new ApiInfoBuilder()
                .title("SpringBoot模版API文档")
                .description("# SpringBoot模版API文档 DESC ")
                .termsOfServiceUrl("http://www.114514.com/")
                .contact(new Contact("Sirenology", "www.114514.com", ""))
                .version("1.0")
                .build())
            // 分组名称
            .groupName("1.0.0.0 v")
            .select()
            // 这里指定文档Controller层扫描包路径
            .apis(RequestHandlerSelectors.basePackage("com.example.management_backend.controllers"))
            .paths(PathSelectors.any())
            .build();
    }
}
