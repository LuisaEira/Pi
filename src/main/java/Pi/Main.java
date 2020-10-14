package Pi;

public class Main {

    static double hits;

    public static double Series(double ent){
//        Code for the implementation in series :
        long startTime = System.nanoTime();
        double pi;
        double N_s = ent;
        double x = Math.random();
        double y = Math.random();
        double hits_s = 0;
        double i = N_s;
        while (i>0){
            if(x*x + y*y <= 1){
                hits_s +=1;
            }
            x = Math.random();
            y = Math.random();
            i -=1;
        }
        pi = 4*hits_s/N_s;
        long endTime = System.nanoTime();
        long dummy = (long) Math.pow(10,6);
        long time = (endTime-startTime)/dummy;
        System.out.println("Series result for N = " + N_s + " : "+ pi + ". Time : " + time + "ms");
        return pi;
    }

    public static double Sharing(double i){
//        Code for the implementation with many threads sharing the same quarter 
//        of a circle
        long startTime = System.nanoTime();
        double pi;
        hits = 0;
        Partage[] P = {
            new Partage(i),
            new Partage(i),
            new Partage(i),
            new Partage(i),
            new Partage(i),
            new Partage(i),
            new Partage(i),
            new Partage(i),
        };
        for(int j = 0; j<P.length; j++){
            P[j].start();
        }
        for(int j = 0; j<P.length; j++){
            try{
                P[j].join();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        double N = i*P.length;
        pi = 4*hits/N;
        long endTime = System.nanoTime();
        long dummy = (long) Math.pow(10,6);
        long time = (endTime-startTime)/dummy;
        System.out.println("Sharing result for N = " + N + " : "+ pi + ". Time : " + time + "ms");
        return pi;
    }

    public static double Mean(double i){
//        Code for the implementation with the value of many independent threads
        long startTime = System.nanoTime();
        double p = 0;
        double N = 0;
        Moyenne[] P = {
            new Moyenne(i),
            new Moyenne(i),
            new Moyenne(i),
            new Moyenne(i),
            new Moyenne(i),
            new Moyenne(i),
            new Moyenne(i),
            new Moyenne(i),
        };
        for(int j = 0; j<P.length; j++){
            P[j].start();
        }
        for(int j = 0; j<P.length; j++){
            try{
                P[j].join();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            
        }
        for(int j = 0; j<P.length; j++){
            p += Moyenne.pi();
        }
        double pi = p/P.length; 
        long endTime = System.nanoTime();
        long dummy = (long) Math.pow(10,6);
        long time = (endTime-startTime)/dummy;
        System.out.println("Mean result for N = " + P.length*i + " : " + pi + ". Time : " + time + "ms");
        return pi;
    }

    public static double Quarter(double i){
//        Code for the implementation with the value of four independent threads
        long startTime = System.nanoTime();
        double p = 0;
        double N = 0;
        Moyenne[] P = {
            new Moyenne(i),
            new Moyenne(i),
            new Moyenne(i),
            new Moyenne(i),
        };
        for(int j = 0; j<P.length; j++){
            P[j].start();
        }
        for(int j = 0; j<P.length; j++){
            try{
                P[j].join();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            
        }
        for(int j = 0; j<P.length; j++){
            p += Moyenne.pi();
        }
        double pi = p/P.length; 
        long endTime = System.nanoTime();
        long dummy = (long) Math.pow(10,6);
        long time = (endTime-startTime)/dummy;
        System.out.println("Quarter result for N = " + P.length*i + " : " + pi + ". Time : " + time + "ms");
        return pi;
    }

    public static void main(String[] args) {
        double i = Math.pow(10,9);
        double pi_s = Series(8*i);
        double pi_sh = Sharing(i);
        double pi_m = Mean(i);
        double pi_q = Quarter(2*i);  

        
    }

}
