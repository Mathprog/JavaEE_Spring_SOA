//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.12.21 à 09:58:24 PM CET 
//


package oc.projet.biblio.client.consumer.generated;

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
 *         &lt;element name="ouvrageWS" type="{http://biblio.io/api/biblio-web-service}ouvrageWS"/&gt;
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
    "ouvrageWS"
})
@XmlRootElement(name = "getOuvrageCreateResponse")
public class GetOuvrageCreateResponse {

    @XmlElement(required = true, nillable = true)
    protected OuvrageWS ouvrageWS;

    /**
     * Obtient la valeur de la propriété ouvrageWS.
     * 
     * @return
     *     possible object is
     *     {@link OuvrageWS }
     *     
     */
    public OuvrageWS getOuvrageWS() {
        return ouvrageWS;
    }

    /**
     * Définit la valeur de la propriété ouvrageWS.
     * 
     * @param value
     *     allowed object is
     *     {@link OuvrageWS }
     *     
     */
    public void setOuvrageWS(OuvrageWS value) {
        this.ouvrageWS = value;
    }

}
