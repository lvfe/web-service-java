/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customer1;

import java.io.FileOutputStream;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

/**
 *
 * @author fengjiao
 */
public class Customer1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        A_customer customer1=new A_customer("#1");
        A_customer customer2=new A_customer("#2");
        customer2.buy();
        for(int i=0;i<7;i++)
        {
            customer1.buy();
        }
        customer2.buy();
        
        
    }
}
