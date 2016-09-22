/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.WareStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author fengjiao
 */
public class XMLBuilder {
    
    private Map<Integer, Integer> goodmap;
    private Document doc;
    private Scanner input;
    private Formatter output;
    
    public XMLBuilder() {
        goodmap = new HashMap<Integer, Integer>();
        try {
            input = new Scanner(new File("C:\\temp.txt"));
        } catch (FileNotFoundException ex) {
            System.err.print("error opening");
            System.exit(1);
        }
        
        
        for (int i = 0; i < 5; i++) {
            goodmap.put(i, Integer.parseInt(input.nextLine()));
        }
        
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Equipment_shop");
            doc.appendChild(rootElement);
            // transaction elements
            Element transaction = doc.createElement("Transaction");
            rootElement.appendChild(transaction);

            // deplicated item element
            for (int i = 0; i < 5; i++) {
                Element item = doc.createElement("Item");
                transaction.appendChild(item);
                
                
                item.setAttribute("NO", String.valueOf(i));
                Element price = doc.createElement("Price");
                price.appendChild(doc.createTextNode(String.valueOf(goodmap.get(i))));
                item.appendChild(price);
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\current_price.xml"));
            transformer.transform(source, result);
            
        } catch (TransformerException ex) {
        } catch (ParserConfigurationException ex) {
        }
        if (input != null) {
            input.close();
        }
    }
    
    public void changeOnce(int No, boolean b) {
        if (b) {
            for (int i = 0; i < 5; i++) {
                if (i == No) {
                    int good = goodmap.get(i);
                    good += good * 0.05;
                    goodmap.put(i, good);
                } else {
                    int good = goodmap.get(i);
                    good -= good * 0.02;
                    goodmap.put(i, good);
                }
                
            }
            try {
                output = new Formatter("C:\\temp.txt");
            } catch (FileNotFoundException ex) {
                
            }
            output.format("%d\n%d\n%d\n%d\n%d", goodmap.get(0), goodmap.get(1), goodmap.get(2), goodmap.get(3), goodmap.get(4));
            if (output != null) {
                output.close();
            }
            addElement();
        }
    }
    
    private void addElement() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder parser = factory.newDocumentBuilder();
            doc = parser.parse(new File("C:\\current_price.xml"));
            
            Element transaction = doc.createElement("Transaction");
            
            doc.getElementsByTagName("Equipment_shop").item(0).appendChild(transaction);
            
            for (int i = 0; i < 5; i++) {
                Element item = doc.createElement("Item");
                transaction.appendChild(item);
                item.setAttribute("NO", String.valueOf(i));
                Element price = doc.createElement("Price");
                price.appendChild(doc.createTextNode(String.valueOf(goodmap.get(i))));
                item.appendChild(price);
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\current_price.xml"));
            transformer.transform(source, result);
            
        } catch (Exception ex) {
        }
    }
   
    
    public String displayXmlString() {
        try {
            TransformerFactory transfac = TransformerFactory.newInstance();
            Transformer trans = transfac.newTransformer();
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder parser = null;
            try {
                parser = factory.newDocumentBuilder();
            } catch (ParserConfigurationException ex) {
            }
            try {
                doc = parser.parse(new File("C:\\current_price.xml"));
            } catch (SAXException ex) {
            } catch (IOException ex) {
            }
            
            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            DOMSource source = new DOMSource(doc);
            trans.transform(source, result);
            String xmlString = sw.toString();
            return xmlString;
        } catch (TransformerException ex) {
            return null;
        }
    }
    
    public int getGood(int id) {
        return goodmap.get(id);
    }
}
