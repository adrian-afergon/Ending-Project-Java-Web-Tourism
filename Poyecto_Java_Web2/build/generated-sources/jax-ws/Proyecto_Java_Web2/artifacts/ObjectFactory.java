
package Proyecto_Java_Web2.artifacts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Proyecto_Java_Web2.artifacts package. 
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

    private final static QName _AltaRecorridoResponse_QNAME = new QName("http://proyecto.ws/", "AltaRecorridoResponse");
    private final static QName _BorrarRecorrido_QNAME = new QName("http://proyecto.ws/", "BorrarRecorrido");
    private final static QName _BorrarRecorridoResponse_QNAME = new QName("http://proyecto.ws/", "BorrarRecorridoResponse");
    private final static QName _AltaRecorrido_QNAME = new QName("http://proyecto.ws/", "AltaRecorrido");
    private final static QName _Register_QNAME = new QName("http://proyecto.ws/", "Register");
    private final static QName _RegisterResponse_QNAME = new QName("http://proyecto.ws/", "RegisterResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Proyecto_Java_Web2.artifacts
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AltaRecorridoResponse }
     * 
     */
    public AltaRecorridoResponse createAltaRecorridoResponse() {
        return new AltaRecorridoResponse();
    }

    /**
     * Create an instance of {@link BorrarRecorrido }
     * 
     */
    public BorrarRecorrido createBorrarRecorrido() {
        return new BorrarRecorrido();
    }

    /**
     * Create an instance of {@link Register }
     * 
     */
    public Register createRegister() {
        return new Register();
    }

    /**
     * Create an instance of {@link RegisterResponse }
     * 
     */
    public RegisterResponse createRegisterResponse() {
        return new RegisterResponse();
    }

    /**
     * Create an instance of {@link BorrarRecorridoResponse }
     * 
     */
    public BorrarRecorridoResponse createBorrarRecorridoResponse() {
        return new BorrarRecorridoResponse();
    }

    /**
     * Create an instance of {@link AltaRecorrido }
     * 
     */
    public AltaRecorrido createAltaRecorrido() {
        return new AltaRecorrido();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaRecorridoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://proyecto.ws/", name = "AltaRecorridoResponse")
    public JAXBElement<AltaRecorridoResponse> createAltaRecorridoResponse(AltaRecorridoResponse value) {
        return new JAXBElement<AltaRecorridoResponse>(_AltaRecorridoResponse_QNAME, AltaRecorridoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BorrarRecorrido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://proyecto.ws/", name = "BorrarRecorrido")
    public JAXBElement<BorrarRecorrido> createBorrarRecorrido(BorrarRecorrido value) {
        return new JAXBElement<BorrarRecorrido>(_BorrarRecorrido_QNAME, BorrarRecorrido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BorrarRecorridoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://proyecto.ws/", name = "BorrarRecorridoResponse")
    public JAXBElement<BorrarRecorridoResponse> createBorrarRecorridoResponse(BorrarRecorridoResponse value) {
        return new JAXBElement<BorrarRecorridoResponse>(_BorrarRecorridoResponse_QNAME, BorrarRecorridoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaRecorrido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://proyecto.ws/", name = "AltaRecorrido")
    public JAXBElement<AltaRecorrido> createAltaRecorrido(AltaRecorrido value) {
        return new JAXBElement<AltaRecorrido>(_AltaRecorrido_QNAME, AltaRecorrido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Register }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://proyecto.ws/", name = "Register")
    public JAXBElement<Register> createRegister(Register value) {
        return new JAXBElement<Register>(_Register_QNAME, Register.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://proyecto.ws/", name = "RegisterResponse")
    public JAXBElement<RegisterResponse> createRegisterResponse(RegisterResponse value) {
        return new JAXBElement<RegisterResponse>(_RegisterResponse_QNAME, RegisterResponse.class, null, value);
    }

}
