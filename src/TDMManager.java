/**
 * Created by ali on 7/1/16.
 */
public class TDMManager extends Thread{
    Thread t;
    String threadName;
    int L, R;
    double P;
    double X;
    int m;
    double[] rForStation;
    Station[] stations;

    public TDMManager(int l, int r, double p, int m, double[] rForStation) {
        L = l;
        R = r;
        P = p;
        X = L/R;
        this.m = m;
        this.rForStation = rForStation;
    }

    public void run() {
        int j = 0;
        while(j < 10) {
            for(int i = 0; i < m; i++) {
                stations[i].sendTime = true;
                try {
                    sleep((long) X*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            j++;
        }

    }

    public void start() {
        System.out.println("TDM Manager start.");
        for(int i = 0; i < m; i++) {
            stations[i] = new Station("station"+i, i, L, R, rForStation[i], P, m);
            stations[i].start();
        }
        if(t == null) {
            t = new Thread(this, threadName);
            t.start();

        }
    }

}
