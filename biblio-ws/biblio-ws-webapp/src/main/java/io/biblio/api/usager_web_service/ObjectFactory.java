//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.11.23 à 07:01:01 PM CET 
//


package io.biblio.api.usager_web_service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the io.biblio.api.usager_web_service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: io.biblio.api.usager_web_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUsagerResponse }
     * 
     */
    public GetUsagerResponse createGetUsagerResponse() {
        return new GetUsagerResponse();
    }

    /**
     * Create an instance of {@link UsagerWS }
     * 
     */
    public UsagerWS createUsagerWS() {
        return new UsagerWS();
    }

    /**
     * Create an instance of {@link GetUsagerCreateRequest }
     * 
     */
    public GetUsagerCreateRequest createGetUsagerCreateRequest() {
        return new GetUsagerCreateRequest();
    }

    /**
     * Create an instance of {@link GetUsagerByEmailRequest }
     * 
     */
    public GetUsagerByEmailRequest createGetUsagerByEmailRequest() {
        return new GetUsagerByEmailRequest();
    }

    /**
     * Create an instance of {@link GetUsagerRequest }
     * 
     */
    public GetUsagerRequest createGetUsagerRequest() {
        return new GetUsagerRequest();
    }

    /**
     * Create an instance of {@link GetUsagerCreateResponse }
     * 
     */
    public GetUsagerCreateResponse createGetUsagerCreateResponse() {
        return new GetUsagerCreateResponse();
    }

    /**
     * Create an instance of {@link GetUsagerByEmailResponse }
     * 
     */
    public GetUsagerByEmailResponse createGetUsagerByEmailResponse() {
        return new GetUsagerByEmailResponse();
    }

}
