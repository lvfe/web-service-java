/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client_applicantion;

import java.util.Scanner;



/**
 *
 * @author fengjiao
 */
public class Client_Applicantion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.print("pls input satellite's name :");
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        System.out.println(transponder(s));
        
        
    }

    private static String transponder(java.lang.String arg0) {
        org.me.sate.SateWS_Service service = new org.me.sate.SateWS_Service();
        org.me.sate.SateWS port = service.getSateWSPort();
        return port.transponder(arg0);
    }


    
    
}
