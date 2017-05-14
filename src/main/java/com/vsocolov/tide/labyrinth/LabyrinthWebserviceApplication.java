package com.vsocolov.tide.labyrinth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class LabyrinthWebserviceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(LabyrinthWebserviceApplication.class);
    }

    public static void main(final String[] args) throws Exception {
        SpringApplication.run(LabyrinthWebserviceApplication.class, args);
    }
}

