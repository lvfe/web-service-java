/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customer2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author fengjiao
 */
public class A_customer {

    private int project_Dollar = 5000;
    private Formatter output;
    private Scanner input;
    private Document doc;
    private Element rootElement;
    private String id;

    public A_customer(String id) {
        this.id = id;
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            doc = docBuilder.newDocument();
            rootElement = doc.createElement("Equipment_shop");
            doc.appendChild(rootElement);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\logs.xml"));
            transformer.transform(source, result);
        } catch (Exception ex) {
        }
    }

    public void toHtml() {
        try {

            TransformerFactory tFactory = TransformerFactory.newInstance();

            Transformer transformer =
                    tFactory.newTransformer(new javax.xml.transform.stream.StreamSource("c:\\current_price.xsl"));

            transformer.transform(new javax.xml.transform.stream.StreamSource("c:\\current_price.xml"),
                    new javax.xml.transform.stream.StreamResult(new FileOutputStream("c:\\current_price.html")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {

            TransformerFactory tFactory = TransformerFactory.newInstance();

            Transformer transformer =
                    tFactory.newTransformer(new javax.xml.transform.stream.StreamSource("c:\\logs.xsl"));

            transformer.transform(new javax.xml.transform.stream.StreamSource("c:\\logs.xml"),
                    new javax.xml.transform.stream.StreamResult(new FileOutputStream("c:\\logs.html")));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void buy() {
        System.out.println();
        System.out.printf("Customer %s want to buy!\n", id);
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder parser = factory.newDocumentBuilder();
            doc = parser.parse(new File("C:\\logs.xml"));
            // transaction elements

            if (project_Dollar > 0) {
                try {
                    input = new Scanner(new File("C:\\temp.txt"));
                } catch (FileNotFoundException ex) {
                    System.err.print("error opening");
                    System.exit(1);
                }
                String out = String.format("%s\t%s\t%s\t%s\t%s", input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine());
                if (input != null) {
                    input.close();
                }
                Element transaction = doc.createElement("Transaction");
                doc.getElementsByTagName("Equipment_shop").item(0).appendChild(transaction);
                transaction.setAttribute("Customer_id", id);


                int digit = (int) (Math.random() * 4);
                System.out.println("the customer want to buy itemNo=" + digit);
                String s = getPrice();
                System.out.println(s);
                System.out.printf("the left money is %d , do you want to buy ?1.buy! 0.sorry,i don't want it ", project_Dollar);
                Scanner in = new Scanner(System.in);
                try {
                    input = new Scanner(new File("C:\\temp.txt"));
                } catch (FileNotFoundException ex) {
                    System.err.print("file not found!");
                    System.exit(1);
                }
                String pri = null;
                if (in.nextInt() == 1) {
                    for (int i = 0; i <= digit; i++) {
                        pri = input.nextLine();
                    }
                    System.out.printf("the price of the item is %s\n", pri);
                    if (project_Dollar >= Integer.parseInt(pri)) {
                        int a = buyItem(digit);
                        System.out.println("buy successfully!\n" + "itemNo:" + digit + "price:" + a);


                        project_Dollar -= a;
                        System.out.println("the money left after buying is" + "itemNo:" + project_Dollar);
                        Element item = doc.createElement("showItemPrice");
                        transaction.appendChild(item);
                        item.appendChild(doc.createTextNode(out));

                        Element buyNo = doc.createElement("buyNo");
                        transaction.appendChild(buyNo);
                        buyNo.setAttribute("NO", String.valueOf(digit));
                        Element price = doc.createElement("Price");
                        price.appendChild(doc.createTextNode(String.valueOf(a)));
                        buyNo.appendChild(price);
                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        Transformer transformer = transformerFactory.newTransformer();
                        DOMSource source = new DOMSource(doc);
                        StreamResult result = new StreamResult(new File("C:\\logs.xml"));
                        transformer.transform(source, result);
                    } else {
                        System.err.println("cannot afford to buy!");
                        System.exit(2);
                    }
                } else {

                    System.out.print("close the execution");
                }
            }


        } catch (Exception ex) {
            System.err.print("Exception");
            System.exit(3);
        }
    }

    private static String getPrice() {
        org.me.warestore.Service_Service service = new org.me.warestore.Service_Service();
        org.me.warestore.Service port = service.getServicePort();
        return port.getPrice();
    }

    private static int buyItem(int itemNo) {
        org.me.warestore.Service_Service service = new org.me.warestore.Service_Service();
        org.me.warestore.Service port = service.getServicePort();
        return port.buyItem(itemNo);
    }
}
