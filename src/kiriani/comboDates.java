/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiriani;

import javax.swing.JComboBox;


/**
 *
 * @author bm
 */
public class comboDates {
    JComboBox combo1,combo2,combo3;
    public void comboLoop(JComboBox box, JComboBox box1, JComboBox box2){
      this.combo1 = box;
      this.combo2 = box1;
      this.combo3 = box2;
      
      combo1.addItem("Day");
      combo2.addItem("Month");
      combo3.addItem("Year");
      for(int i=1; i<=31; i++){
          if(i<10){
              combo1.addItem("0"+i);
          }else{
              combo1.addItem(i);
          }
      }
      for(int i=1; i<=12; i++){
          if(i<10){
              combo2.addItem("0"+i);
          }else{
              combo2.addItem(i);
          }
      }
      for(int i=1900; i<2061; i++){
          combo3.addItem(i);
      }
    }
    
}
