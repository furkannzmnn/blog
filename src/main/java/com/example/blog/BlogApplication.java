package com.example.blog;

import com.example.blog.model.Author;
import com.example.blog.model.Blog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
@EnableSwagger2
public class BlogApplication {

    public static void main(String[] args) {

      SpringApplication.run(BlogApplication.class);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.blog"))
                .build();
    }


}
