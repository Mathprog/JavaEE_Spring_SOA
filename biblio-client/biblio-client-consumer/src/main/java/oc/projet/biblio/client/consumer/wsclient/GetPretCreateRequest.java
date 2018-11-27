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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="usager" type="{http://biblio.io/api/biblio-web-service}usagerWS"/&gt;
 *         &lt;element name="exemplaire" type="{http://biblio.io/api/biblio-web-service}exemplaireWS"/&gt;
 *         &lt;element name="datePret" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="dateFin" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
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
    "usager",
    "exemplaire",
    "datePret",
    "dateFin"
})
@XmlRootElement(name = "getPretCreateRequest")
public class GetPretCreateRequest {

    @XmlElement(required = true)
    protected UsagerWS usager;
    @XmlElement(required = true)
    protected ExemplaireWS exemplaire;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datePret;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateFin;

    /**
     * Obtient la valeur de la propriété usager.
     * 
     * @return
     *     possible object is
     *     {@link UsagerWS }
     *     
     */
    public UsagerWS getUsager() {
        return usager;
    }

    /**
     * Définit la valeur de la propriété usager.
     * 
     * @param value
     *     allowed object is
     *     {@link UsagerWS }
     *     
     */
    public void setUsager(UsagerWS value) {
        this.usager = value;
    }

    /**
     * Obtient la valeur de la propriété exemplaire.
     * 
     * @return
     *     possible object is
     *     {@link ExemplaireWS }
     *     
     */
    public ExemplaireWS getExemplaire() {
        return exemplaire;
    }

    /**
     * Définit la valeur de la propriété exemplaire.
     * 
     * @param value
     *     allowed object is
     *     {@link ExemplaireWS }
     *     
     */
    public void setExemplaire(ExemplaireWS value) {
        this.exemplaire = value;
    }

    /**
     * Obtient la valeur de la propriété datePret.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatePret() {
        return datePret;
    }

    /**
     * Définit la valeur de la propriété datePret.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatePret(XMLGregorianCalendar value) {
        this.datePret = value;
    }

    /**
     * Obtient la valeur de la propriété dateFin.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateFin() {
        return dateFin;
    }

    /**
     * Définit la valeur de la propriété dateFin.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateFin(XMLGregorianCalendar value) {
        this.dateFin = value;
    }

}