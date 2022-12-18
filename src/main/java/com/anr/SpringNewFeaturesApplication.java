package com.anr;

import com.anr.props.MailProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MailProperties.class)
public class SpringNewFeaturesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringNewFeaturesApplication.class, args);
    }

}
