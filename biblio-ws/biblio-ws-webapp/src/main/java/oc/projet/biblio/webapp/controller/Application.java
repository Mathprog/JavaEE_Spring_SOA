package oc.projet.biblio.webapp.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages="oc.projet.biblio")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}