package com.ollogicalsolutions.viptotrip.config;

import com.ollogicalsolutions.viptotrip.services.converters.EventDtoConverter;
import com.ollogicalsolutions.viptotrip.services.converters.FlightDtoConverter;
import com.ollogicalsolutions.viptotrip.services.dto.EventDTO;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;

@Configuration
@ComponentScan(basePackages = "com.ollogicalsolutions")
@EnableJpaRepositories(basePackages = "com.ollogicalsolutions")
@EnableTransactionManagement
public class WebConfig implements WebMvcConfigurer {


    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("/WEB-INF/views/");
        resourceViewResolver.setSuffix(".jsp");
        return resourceViewResolver;
    }

    @Override
    public void addFormatters(final FormatterRegistry registry) {
        registry.addConverter(eventDtoConverter());

    }

    @Bean
    public EventDtoConverter eventDtoConverter() {
        return new EventDtoConverter();
    }

    @Bean
    public FlightDtoConverter flightDtoConverter() {return new FlightDtoConverter();}

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public ModelMapper modelMapper() {return new ModelMapper();}

}
