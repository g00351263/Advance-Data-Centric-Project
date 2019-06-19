//Author Raja Naseer Ahmed Khan G00351263, Data Centric 2019 Project //

package com.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// class declared as spring boot application //
@SpringBootApplication
public class FinalProjV1Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FinalProjV1Application.class);
    }
    
// execution of main class //
    public static void main(String[] args) {
        SpringApplication.run(FinalProjV1Application.class, args);
    }

}
