
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mbehlok
 */
public class LoadTestLoginThread extends Thread {
        private int id;
    public void run(){

        while(true){
            try{
               Connection.Response res = Jsoup.connect("http://www.caracolplay.com/add_suscripcion?origen=suscripcion&tx=1").followRedirects(true).timeout(0).header("Loadtest","X1256836811").header("Host","www.caracolplay.com").userAgent("Mozilla/5.0 (X11; Fedora; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36").execute();
               String url = res.url().toString();
               // System.out.println(url);
               Document res2 = res.parse();
               
               String fid = res2.getElementsByAttributeValueMatching("name", "form_build_id").first().attr("value");
               
              // System.setProperty("http.proxyHost", "127.0.0.1");
              // System.setProperty("http.proxyPort", "8080");
               
               
               String randomUsername = Long.toHexString(Double.doubleToLongBits(Math.random()));
               String randomDomain = Long.toHexString(Double.doubleToLongBits(Math.random()));
                System.out.println(randomUsername);
               
            //    System.out.println(randomUsername);
               
               Document doc = Jsoup.connect(url).header("Referer", url).cookies(res.cookies()).timeout(0).header("Loadtest","X1256836811")
                       .data("play_onestepcheckout[username]",randomUsername)
                       .data("play_onestepcheckout[pass][pass1]","123")
                       .data("play_onestepcheckout[pass][pass2]","123")
                       .data("customer_profile_billing[field_nombre_cliente][und][0][value]","qwe")
                       .data("customer_profile_billing[field_apellido_cliente][und][0][value]","qwe")
                       .data("customer_profile_billing[field_ciudad_pais_cliente][und][0][target_id]","As, República Checa (21428)")
                       .data("customer_profile_billing[field_direccion_cliente][und][0][value]","123")
                       .data("customer_profile_billing[field_phone][und][0][value]","123")
                       .data("customer_profile_billing[field_email][und][0][value]",randomUsername+'@'+randomDomain+".com")
                       .data("customer_profile_billing[field_document_type][und]","CC")
                       .data("customer_profile_billing[field_documentnumber][und][0][value]","123")
                       .data("customer_profile_billing[field_renovacion_automatica][und]","1")
                       .data("play_onestepcheck_terms[fieldset_complementarios][info_mail]","1")
                       .data("play_onestepcheck_terms[fieldset_complementarios][info_comercial]","1")
                       .data("play_onestepcheck_terms[fieldset_terminos][acepto_terminos]","1")
                       .data("play_onestepcheck_terms[fieldset_terminos][acepto_habeas]","1")
                       .data("play_onestepcheck_terms[fieldset_terminos][acepto_reproducir]","1")
                       .data("commerce_p2p_aim_select_methods[group_payment_methods][methods]","visa")
                       .data("op","Pagar")
                       .data("form_build_id",fid)
                       .data("form_id","commerce_checkout_form_checkout").header("Host","www.caracolplay.com").userAgent("Mozilla/5.0 (X11; Fedora; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36").post();
               
                System.out.println("User : "+randomUsername);
               
             //   System.out.println(doc.html());
            }catch (Exception e){
                e.printStackTrace();
             System.out.println("Connexion finished from thread: "+ id);
            }
        }

    }

    public LoadTestLoginThread(int id){
        this.id = id;
    }

    
    
}
