package oc.projet.biblio.client.consumer;

import oc.projet.biblio.client.consumer.generated.GetUsagerResponse;

import oc.projet.biblio.client.consumer.ws.UsagerClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Configuration
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);

    }

    @Bean
    CommandLineRunner lookup(UsagerClient quoteClient) {
        return args -> {
            GetUsagerResponse response = quoteClient.getUsagerClientRequest();
            System.err.println("La taille des Usager : " + response.getUsagerWS().size());
        };
    }
}
