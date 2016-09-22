/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customer2;

import java.io.FileOutputStream;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

/**
 *
 * @author fengjiao
 */
public class Customer2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        A_customer customer1=new A_customer("#1");
        A_customer customer2=new A_customer("#2");
        for(int i=0;i<5;i++)
        {
            customer1.buy();
        }
        customer2.buy();
        customer1.toHtml();
        customer2.toHtml();
       
        
        
    }
}
