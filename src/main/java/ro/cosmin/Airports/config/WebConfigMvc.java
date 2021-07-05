package ro.cosmin.Airports.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigMvc implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry mvcRegistry) {
        mvcRegistry.addViewController("/login").setViewName("login");
    }
}

