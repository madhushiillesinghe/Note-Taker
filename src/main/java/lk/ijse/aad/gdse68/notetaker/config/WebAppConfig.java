package lk.ijse.aad.gdse68.notetaker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


//request response directly handling using this
@Configuration
@ComponentScan(basePackages = "lk.ijse.aad.gdse68.notetaker")
@EnableWebMvc

public class WebAppConfig {
}
