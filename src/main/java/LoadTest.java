/**
 * Created by mbehlok on 8/22/16.
 */
public class LoadTest {

    public static String url;


    public static void main(String a[]){

        url = a[0];

        int threads = Integer.valueOf(a[1]);

        for(int i = 0 ; i < threads; i++){
            LoatTestThread ltt = new LoatTestThread(i);
            ltt.start();
        }



    }
}
