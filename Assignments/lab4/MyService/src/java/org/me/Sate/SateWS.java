/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.Sate;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

/**
 *
 * @author fengjiao
 */
@WebService(serviceName = "SateWS")
@Stateless()
public class SateWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "transponder")
    public String transponder(String argument) {
     StringBuilder r=new StringBuilder("");
         try {
            File file = new File("E:/satellites.xml");
           
            DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbfac.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
             

             System.out.println("Root element " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("sat");
            System.out.println("Information about all the sat");

          
             for (int i = 0; i < nodeList.getLength(); i++) {

                Node actualNode = nodeList.item(i);

                if (actualNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element nodeElement = (Element) actualNode;
                    if (nodeElement.getAttribute("name").equals(argument.trim())) {
                        NodeList findElementList = nodeElement.getElementsByTagName("transponder");
                        Element e = (Element) findElementList.item(0);
                        r.append(String.format("frequency:%s\tsymbol_rate:%s\tpolarization:%s\tfec_inner:%s\n", e.getAttribute("frequency"), e.getAttribute("symbol_rate"),e.getAttribute("polarization"),e.getAttribute("fec_inner")));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // System.out.println(r);
        }
       return r.toString();
    }

    /**
     * Web service operation
     */
    
  
}
