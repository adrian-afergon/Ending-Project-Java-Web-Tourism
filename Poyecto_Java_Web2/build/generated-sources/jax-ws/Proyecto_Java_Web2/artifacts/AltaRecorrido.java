
package Proyecto_Java_Web2.artifacts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para AltaRecorrido complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AltaRecorrido">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idUsuario" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idRecorrido" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="niños" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="adultos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AltaRecorrido", propOrder = {
    "idUsuario",
    "idRecorrido",
    "ni\u00f1os",
    "adultos"
})
public class AltaRecorrido {

    protected int idUsuario;
    protected int idRecorrido;
    protected int niños;
    protected int adultos;

    /**
     * Obtiene el valor de la propiedad idUsuario.
     * 
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Define el valor de la propiedad idUsuario.
     * 
     */
    public void setIdUsuario(int value) {
        this.idUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad idRecorrido.
     * 
     */
    public int getIdRecorrido() {
        return idRecorrido;
    }

    /**
     * Define el valor de la propiedad idRecorrido.
     * 
     */
    public void setIdRecorrido(int value) {
        this.idRecorrido = value;
    }

    /**
     * Obtiene el valor de la propiedad niños.
     * 
     */
    public int getNiños() {
        return niños;
    }

    /**
     * Define el valor de la propiedad niños.
     * 
     */
    public void setNiños(int value) {
        this.niños = value;
    }

    /**
     * Obtiene el valor de la propiedad adultos.
     * 
     */
    public int getAdultos() {
        return adultos;
    }

    /**
     * Define el valor de la propiedad adultos.
     * 
     */
    public void setAdultos(int value) {
        this.adultos = value;
    }

}
