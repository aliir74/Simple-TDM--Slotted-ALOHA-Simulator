import java.util.Scanner;

/**
 * Created by ali on 6/29/16.
 */


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter m, L, R, P:");
        int m, l, r;
        double p;
        m = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        p = sc.nextDouble();
        double[] rForStation = new double[m];
        System.out.println("Enter rForStations: ");
        for(int i = 0; i < m; i++) {
            rForStation[i] = sc.nextDouble();
        }

        TDMManager manager = new TDMManager(l, r, p, m, rForStation);
        manager.start();
    }
}
