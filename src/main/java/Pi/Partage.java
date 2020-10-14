/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pi;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author luisa
 */
public class Partage extends Thread{
    double i;
    public static Object lock = new Object();

    public void run(){
        double x = ThreadLocalRandom.current().nextDouble();
        double y = ThreadLocalRandom.current().nextDouble();
        while (i>0){
            if(x*x + y*y <= 1){
                synchronized(lock){
                    Main.hits += 1;
                }
            }
            x = ThreadLocalRandom.current().nextDouble();
            y = ThreadLocalRandom.current().nextDouble();
            i -=1;
        }   
    }
    public Partage(double ent){
        i = ent;
    }
}
