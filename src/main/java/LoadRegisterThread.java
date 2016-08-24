
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
public class LoadRegisterThread extends Thread {
        private int id;
        
            public LoadRegisterThread(int id){
        this.id = id;
    }
    public void run(){
        while(true){
try{
    
               Connection.Response res = Jsoup.connect("http://www.caracolplay.com/suscripcion/login?destination=suscripcion").followRedirects(true).timeout(0).header("Loadtest","X1256836811").header("Host","www.caracolplay.com").userAgent("Mozilla/5.0 (X11; Fedora; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36").execute();
               String url = res.url().toString();
               // System.out.println(url);
               Document res2 = res.parse();
               
               String fid = res2.getElementsByAttributeValueMatching("name", "form_build_id").get(1).attr("value");
               //System.out.println(fid);
               Document doc = Jsoup.connect(url).followRedirects(true).header("Referer", "http://www.caracolplay.com/suscripcion/login?destination=suscripcion").cookies(res.cookies()).timeout(0).header("Loadtest","X1256836811").header("Host","www.caracolplay.com").userAgent("Mozilla/5.0 (X11; Fedora; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36").
               data("name","mbehlok").data("pass","CApSNtc9").data("form_build_id",fid).data("form_id","user_login_block").data("op","Ingresar").post();
               //System.out.println(doc.html());
               System.out.println("Logged in from thread: "+id);
}catch(Exception e){
    
    e.printStackTrace();
    
}
        }
    }
    
}
