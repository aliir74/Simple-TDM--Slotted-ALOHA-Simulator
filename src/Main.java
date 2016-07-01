import java.util.Scanner;

/**
 * Created by ali on 6/29/16.
 */


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter protocol(1-3), m, L, R, P:");
        int protocol = 2;
        int m, l = 1, r = 1;
        double p = 0;
        //protocol = sc.nextInt();
        m = sc.nextInt();
        //l = sc.nextInt();
        //r = sc.nextInt();
        //p = sc.nextDouble();
        double[] rForStation = new double[m];
        System.out.println("Enter rForStations: ");
        for(int i = 0; i < m; i++) {
            rForStation[i] = sc.nextDouble();
        }
        if(protocol == 1) {
            TDMManager manager = new TDMManager(l, r, p, m, rForStation);
            manager.start();
        } else if(protocol == 2) {
            SAManager saManager = new SAManager(l, r, p, m, rForStation);
            saManager.start();

            saManager.showCollisions();
        } else {

        }
    }
}
