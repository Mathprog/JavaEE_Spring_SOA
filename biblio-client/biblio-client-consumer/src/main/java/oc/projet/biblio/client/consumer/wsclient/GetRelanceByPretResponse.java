//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.11.27 à 06:46:56 PM CET 
//


package oc.projet.biblio.client.consumer.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="relance" type="{http://biblio.io/api/biblio-web-service}relanceWS"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "relance"
})
@XmlRootElement(name = "getRelanceByPretResponse")
public class GetRelanceByPretResponse {

    @XmlElement(required = true)
    protected RelanceWS relance;

    /**
     * Obtient la valeur de la propriété relance.
     * 
     * @return
     *     possible object is
     *     {@link RelanceWS }
     *     
     */
    public RelanceWS getRelance() {
        return relance;
    }

    /**
     * Définit la valeur de la propriété relance.
     * 
     * @param value
     *     allowed object is
     *     {@link RelanceWS }
     *     
     */
    public void setRelance(RelanceWS value) {
        this.relance = value;
    }

}