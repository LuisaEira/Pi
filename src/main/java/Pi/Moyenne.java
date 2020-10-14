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
public class Moyenne extends Thread{
    double i;
    static double pi;
    double hits;

    public void run(){
        double x = ThreadLocalRandom.current().nextDouble();
        double y = ThreadLocalRandom.current().nextDouble();
        double N = i;
        while (i>0){
            if(x*x + y*y <= 1){
                hits += 1;
            }
            x = ThreadLocalRandom.current().nextDouble();
            y = ThreadLocalRandom.current().nextDouble();
            i -=1;
        }   
        pi = 4*hits/N;
    }
    
    public static double pi(){
        return pi;
    }

    public Moyenne(double ent){
        i = ent;
        hits = 0;
    }
}