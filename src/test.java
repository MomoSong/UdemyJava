import java.util.ArrayList;

/**
 * Created by johnm on 2017-01-16.
 */
public class test {
    public static void main(String[] args) {
        ArrayList<Double> tra = new ArrayList<>();

        for (int i = 0; i<20; i++){
            tra.add(Math.random()*100 +1);
        }

        for (double i : tra){
            int j = 1;
            System.out.printf("%d# : %.3f\n", j++, i);
        }
    }
}
