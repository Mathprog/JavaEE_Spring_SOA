package oc.projet.biblio.client.consumer;

import oc.projet.biblio.client.consumer.generated.*;

import oc.projet.biblio.client.consumer.ws.OuvrageClient;
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
            System.err.println("Nombre d'usagers dans la BDD : " + response.getUsagerWS().size());

            int id = 518;
            GetUsagerByIdResponse responseUsagerById = quoteClient.getUsagerByIdClientRequest(id);
            System.err.println("Usager trouvé avec l'id : " + id + " email = " + responseUsagerById.getUsagerWS().getEmail());

            String email = "mathieu-martinez";
            GetUsagerByEmailResponse responseUsagerByEmail = quoteClient.getUsagerByEmailClientRequest(email);
            System.err.println("Usager trouvé avec l'email : " + email + " / Usager id = " + responseUsagerByEmail.getUsagerWS().getId() + " email = " + responseUsagerByEmail.getUsagerWS().getEmail());

            String email_create = "mathieu-martinez-client2";
            GetUsagerCreateResponse responseCreateUsager = quoteClient.getUsagerCreateClientRequest(email_create);
            System.err.println("Usager crée avec l'email : " + email_create + " / Usager id = " +
                    responseCreateUsager.getUsagerWS().getId() + " email = " +
                    responseCreateUsager .getUsagerWS().getEmail());

        };
    }

    @Bean
    CommandLineRunner lookup2(OuvrageClient quoteClient) {
        return args -> {
            GetOuvrageResponse response = quoteClient.geOuvrageClientRequest();
            System.err.println("Nombre d'ouvrages dans la BDD : " + response.getOuvrageWS().size());

            int id = 519;
            GetOuvrageByIdResponse responseOuvrageById = quoteClient.getOuvrageByIdClientRequest(id);
            System.err.println("Ouvrage trouvé avec l'id : " + id + " titre = " + responseOuvrageById.getOuvrageWS().getTitre());

            String titre = "Spring Framework 2";
            GetOuvrageByTitreResponse ouvrageByTitreResponse = quoteClient.getOuvrageByTitreClientRequest(titre);
            System.err.println( "Ouvrage trouvé avec le titre : " + titre + " / Ouvrage id = " + ouvrageByTitreResponse.getOuvrageWS().get(0).getId() + " titre = " + ouvrageByTitreResponse.getOuvrageWS().get(0).getTitre());

            String titre_create = "Client Spring Framework SOAP";
            GetOuvrageCreateResponse ouvrageCreateResponse = quoteClient.getOuvrageCreateClientRequest(titre_create);
            System.err.println(" Ouvrage crée : id : " + ouvrageCreateResponse.getOuvrageWS().getId() + " titre : " + ouvrageCreateResponse.getOuvrageWS().getTitre());

        };
    }
}
