
package org.me.sate;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.me.sate package. 
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

    private final static QName _Add_QNAME = new QName("http://Sate.me.org/", "add");
    private final static QName _Hello_QNAME = new QName("http://Sate.me.org/", "hello");
    private final static QName _AddResponse_QNAME = new QName("http://Sate.me.org/", "addResponse");
    private final static QName _Transponder_QNAME = new QName("http://Sate.me.org/", "transponder");
    private final static QName _TransponderResponse_QNAME = new QName("http://Sate.me.org/", "transponderResponse");
    private final static QName _HelloResponse_QNAME = new QName("http://Sate.me.org/", "helloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.me.sate
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link AddResponse }
     * 
     */
    public AddResponse createAddResponse() {
        return new AddResponse();
    }

    /**
     * Create an instance of {@link Add }
     * 
     */
    public Add createAdd() {
        return new Add();
    }

    /**
     * Create an instance of {@link TransponderResponse }
     * 
     */
    public TransponderResponse createTransponderResponse() {
        return new TransponderResponse();
    }

    /**
     * Create an instance of {@link Transponder }
     * 
     */
    public Transponder createTransponder() {
        return new Transponder();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Add }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Sate.me.org/", name = "add")
    public JAXBElement<Add> createAdd(Add value) {
        return new JAXBElement<Add>(_Add_QNAME, Add.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Sate.me.org/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Sate.me.org/", name = "addResponse")
    public JAXBElement<AddResponse> createAddResponse(AddResponse value) {
        return new JAXBElement<AddResponse>(_AddResponse_QNAME, AddResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Transponder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Sate.me.org/", name = "transponder")
    public JAXBElement<Transponder> createTransponder(Transponder value) {
        return new JAXBElement<Transponder>(_Transponder_QNAME, Transponder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransponderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Sate.me.org/", name = "transponderResponse")
    public JAXBElement<TransponderResponse> createTransponderResponse(TransponderResponse value) {
        return new JAXBElement<TransponderResponse>(_TransponderResponse_QNAME, TransponderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Sate.me.org/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

}
