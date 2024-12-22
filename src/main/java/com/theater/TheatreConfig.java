package com.theater;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TheatreConfig {

	@Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
}
