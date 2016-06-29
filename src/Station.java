/**
 * Created by ali on 6/29/16.
 */
public class Station extends Thread {
    Thread t;
    String threadName;
    int stationNumber;
    int L, R, rForStation, P;
    double X;

    public Station(String threadName, int stationNumber, int l, int r, int rForStation, int p) {
        this.threadName = threadName;
        this.stationNumber = stationNumber;
        L = l;
        R = r;
        this.rForStation = rForStation;
        P = p;
        X = L/R;
    }

    public void run() {

    }

    public void start() {

    }
}
