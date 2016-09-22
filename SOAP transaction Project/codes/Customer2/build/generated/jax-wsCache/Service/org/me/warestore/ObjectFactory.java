
package org.me.warestore;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.me.warestore package. 
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

    private final static QName _BuyItem_QNAME = new QName("http://WareStore.me.org/", "buyItem");
    private final static QName _BuyItemResponse_QNAME = new QName("http://WareStore.me.org/", "buyItemResponse");
    private final static QName _GetPriceResponse_QNAME = new QName("http://WareStore.me.org/", "getPriceResponse");
    private final static QName _GetPrice_QNAME = new QName("http://WareStore.me.org/", "getPrice");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.me.warestore
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BuyItem }
     * 
     */
    public BuyItem createBuyItem() {
        return new BuyItem();
    }

    /**
     * Create an instance of {@link GetPrice }
     * 
     */
    public GetPrice createGetPrice() {
        return new GetPrice();
    }

    /**
     * Create an instance of {@link BuyItemResponse }
     * 
     */
    public BuyItemResponse createBuyItemResponse() {
        return new BuyItemResponse();
    }

    /**
     * Create an instance of {@link GetPriceResponse }
     * 
     */
    public GetPriceResponse createGetPriceResponse() {
        return new GetPriceResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuyItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WareStore.me.org/", name = "buyItem")
    public JAXBElement<BuyItem> createBuyItem(BuyItem value) {
        return new JAXBElement<BuyItem>(_BuyItem_QNAME, BuyItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuyItemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WareStore.me.org/", name = "buyItemResponse")
    public JAXBElement<BuyItemResponse> createBuyItemResponse(BuyItemResponse value) {
        return new JAXBElement<BuyItemResponse>(_BuyItemResponse_QNAME, BuyItemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WareStore.me.org/", name = "getPriceResponse")
    public JAXBElement<GetPriceResponse> createGetPriceResponse(GetPriceResponse value) {
        return new JAXBElement<GetPriceResponse>(_GetPriceResponse_QNAME, GetPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WareStore.me.org/", name = "getPrice")
    public JAXBElement<GetPrice> createGetPrice(GetPrice value) {
        return new JAXBElement<GetPrice>(_GetPrice_QNAME, GetPrice.class, null, value);
    }

}
