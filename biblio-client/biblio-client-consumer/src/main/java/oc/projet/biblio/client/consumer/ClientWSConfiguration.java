package oc.projet.biblio.client.consumer;

import oc.projet.biblio.client.consumer.ws.OuvrageClient;
import oc.projet.biblio.client.consumer.ws.UsagerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ClientWSConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("oc.projet.biblio.client.consumer.generated");
        return marshaller;
    }

   @Bean
    public UsagerClient usagerClient(Jaxb2Marshaller marshaller) {
        UsagerClient usagerClient = new UsagerClient();
        usagerClient.setDefaultUri("http://localhost:8080/soapws");
        usagerClient.setMarshaller(marshaller);
        usagerClient.setUnmarshaller(marshaller);
        return usagerClient;
    }

    @Bean
    public OuvrageClient ouvrageClient(Jaxb2Marshaller marshaller){
        OuvrageClient ouvrageClient = new OuvrageClient();
        ouvrageClient.setDefaultUri("http://localhost:8080/soapws");
        ouvrageClient.setMarshaller(marshaller);
        ouvrageClient.setUnmarshaller(marshaller);
        return ouvrageClient;
    }

}