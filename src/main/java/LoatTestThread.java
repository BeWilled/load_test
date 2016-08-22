import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by mbehlok on 8/22/16.
 */
public class LoatTestThread extends Thread {
    private int id;
    public void run(){

        while(true){
            try{
               Document doc = Jsoup.connect(LoadTest.url).timeout(0).header("SESS599fc0c076cf7c7ccf1b4b6eb15016a4", "oTgABCpqJcHNcjrF-ULSwZPUhNDtH9dhNLEY2wDpJEg").header("Loadtest","X1256836811").header("Host","www.caracolplay.com").userAgent("Mozilla/5.0 (X11; Fedora; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36").get();
               // System.out.println(doc.html());
                System.out.println("Connexion finished from thread: "+ id);
            }catch (Exception e){
                //e.printStackTrace();
            }
        }

    }

    public LoatTestThread(int id){
        this.id = id;
    }


}
