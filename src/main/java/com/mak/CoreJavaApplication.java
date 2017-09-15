package com.mak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@SpringBootApplication
public class CoreJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreJavaApplication.class, args);
    }
}
