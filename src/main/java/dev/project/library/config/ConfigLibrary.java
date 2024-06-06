package dev.project.library.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@Configuration()
@PropertySources({
    @PropertySource(value = "classpath:library.properties", encoding = "UTF-8")
})
public class ConfigLibrary {

}
