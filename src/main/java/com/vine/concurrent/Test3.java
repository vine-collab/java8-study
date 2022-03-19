package com.vine.concurrent;

/**
 * @author 阿季 
 * @date 2022-03-19 17:17
 */

public class Test3 {

   private Object object =  new Object();

   public void method() {
       synchronized (object) {
           System.out.println("hello word");
       }
   }


}
