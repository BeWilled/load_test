/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mbehlok
 */
public class LoadRegister {
    
    public static void main(String a[]){
                int threads = 1;

        for(int i = 0 ; i < threads; i++){
            LoadRegisterThread ltt = new LoadRegisterThread(i);
            ltt.start();
        }
    }
    
    
    
}
