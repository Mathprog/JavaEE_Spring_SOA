//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.12.21 à 09:15:54 PM CET 
//


package io.biblio.api.biblio_web_service;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter1;


/**
 * <p>Classe Java pour ouvrageWS complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ouvrageWS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="titre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="auteur" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="resume" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="imageb" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="ImageBase64DataString" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nbDispo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ouvrageWS", propOrder = {
    "id",
    "titre",
    "auteur",
    "resume",
    "date",
    "imageb",
    "imageBase64DataString",
    "nbDispo"
})
public class OuvrageWS {

    protected int id;
    @XmlElement(required = true)
    protected String titre;
    @XmlElement(required = true)
    protected String auteur;
    @XmlElement(required = true)
    protected String resume;
    @XmlElement(required = true, type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected LocalDate date;
    @XmlElement(required = true, nillable = true)
    protected byte[] imageb;
    @XmlElement(name = "ImageBase64DataString", required = true, nillable = true)
    protected String imageBase64DataString;
    protected Integer nbDispo;

    /**
     * Obtient la valeur de la propriété id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété titre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Définit la valeur de la propriété titre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitre(String value) {
        this.titre = value;
    }

    /**
     * Obtient la valeur de la propriété auteur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * Définit la valeur de la propriété auteur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuteur(String value) {
        this.auteur = value;
    }

    /**
     * Obtient la valeur de la propriété resume.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResume() {
        return resume;
    }

    /**
     * Définit la valeur de la propriété resume.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResume(String value) {
        this.resume = value;
    }

    /**
     * Obtient la valeur de la propriété date.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Définit la valeur de la propriété date.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(LocalDate value) {
        this.date = value;
    }

    /**
     * Obtient la valeur de la propriété imageb.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getImageb() {
        return imageb;
    }

    /**
     * Définit la valeur de la propriété imageb.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setImageb(byte[] value) {
        this.imageb = value;
    }

    /**
     * Obtient la valeur de la propriété imageBase64DataString.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageBase64DataString() {
        return imageBase64DataString;
    }

    /**
     * Définit la valeur de la propriété imageBase64DataString.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageBase64DataString(String value) {
        this.imageBase64DataString = value;
    }

    /**
     * Obtient la valeur de la propriété nbDispo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbDispo() {
        return nbDispo;
    }

    /**
     * Définit la valeur de la propriété nbDispo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbDispo(Integer value) {
        this.nbDispo = value;
    }

}
