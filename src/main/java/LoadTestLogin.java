

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mbehlok
 */
public class LoadTestLogin {
    
    public static String url;
   
        public static void main(String a[]){


        int threads = Integer.valueOf(a[0]);

        for(int i = 0 ; i < threads; i++){
            LoadTestLoginThread ltt = new LoadTestLoginThread(i);
            ltt.start();
        }



    }
    
}
