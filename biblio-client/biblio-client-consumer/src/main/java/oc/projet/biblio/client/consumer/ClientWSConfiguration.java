package oc.projet.biblio.client.consumer;

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
        UsagerClient client = new UsagerClient();
        client.setDefaultUri("http://localhost:8080/soapws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}