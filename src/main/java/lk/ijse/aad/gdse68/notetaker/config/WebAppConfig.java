package lk.ijse.aad.gdse68.notetaker.config;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


//request response directly handling using this
@Configuration
@ComponentScan(basePackages = "lk.ijse.aad.gdse68.notetaker")
//directly connect to the presentation layer
@EnableWebMvc
@EnableJpaRepositories(basePackages = "lk.ijse.aad.gdse68.notetaker")
@EnableTransactionManagement
@MultipartConfig(
        //ran ekai tempory memory eki invoke weno threshold ekst wads adunam file ekn manage krnnee ita wadinm primary memory ekn krnne epr performance adu weno.wadinm secondary memory eka eno
        fileSizeThreshold = 102*1024*2, //2MB,
        // maximum file size(upload karana file size eka)
        maxFileSize = 1024*1024*10,//10MB
        //uploaded file included request flie size
        maxRequestSize = 1024*1024*50 //50MB
)
public class WebAppConfig {
}
