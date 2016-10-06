/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiriani;

import java.util.Random;

/**
 *
 * @author bm
 */
public class kMethods {
    
    
    public static String gen(){
        String alpha = new String("1234567890");
        int n = alpha.length();
        String result = new String();
        Random r = new Random();
        
        for(int i=0; i<8; i++){
            result = result + alpha.charAt(r.nextInt(n));            
        }
        return result;
    }

  }
    

