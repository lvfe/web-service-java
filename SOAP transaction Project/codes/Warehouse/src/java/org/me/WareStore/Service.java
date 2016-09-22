/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.WareStore;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author fengjiao
 */
@WebService(serviceName = "Service")
public class Service {
    public XMLBuilder xmlBuilder=null;

    public Service() {
        xmlBuilder=new XMLBuilder();
    }
    
    @WebMethod(operationName = "getPrice")
    public String getPrice() {
        return xmlBuilder.displayXmlString();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "buyItem")
    public int buyItem(@WebParam(name = "itemNo") int itemNo) {
        if(itemNo>=0&&itemNo<5)
        {
            int price = xmlBuilder.getGood(itemNo);
            xmlBuilder.changeOnce(itemNo, true);
            return price;
        }
        return -1;
    }
    
}