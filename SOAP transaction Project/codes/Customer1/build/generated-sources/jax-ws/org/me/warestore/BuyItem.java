
package org.me.warestore;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for buyItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="buyItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="itemNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buyItem", propOrder = {
    "itemNo"
})
public class BuyItem {

    protected int itemNo;

    /**
     * Gets the value of the itemNo property.
     * 
     */
    public int getItemNo() {
        return itemNo;
    }

    /**
     * Sets the value of the itemNo property.
     * 
     */
    public void setItemNo(int value) {
        this.itemNo = value;
    }

}
