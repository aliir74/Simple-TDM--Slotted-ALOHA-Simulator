/**
 * Created by ali on 6/29/16.
 */
public class Station extends Thread {
    Thread t;
    String threadName;
    int stationNumber;
    int L, R;
    double rForStation, P;
    double X;
    int m;
    boolean sendTime;
    double frame;

    public Station(String threadName, int stationNumber, int l, int r, double rForStation, double p, int m) {
        this.threadName = threadName;
        this.stationNumber = stationNumber;
        L = l;
        R = r;
        this.rForStation = rForStation; // frame per second
        P = p;
        X = L/R;
        this.m = m;
        sendTime = false;
        frame = X*rForStation*stationNumber;
    }

    public void run() {
        int j = 0;
        while(j < 10) {
            while(!sendTime) {
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            sendTime = false;
            if(frame < 1) {
                System.err.println("Station " + stationNumber + " has no packet to send! " + frame);
                frame += rForStation*X*(m-1);
                continue;
            }
            frame -= 1;
            System.out.println("Station " + stationNumber + " sent 1 packet! " + frame);
            frame += rForStation*X*(m-1);
            j++;
        }

    }

    public void start() {
        System.out.println("Station " + stationNumber + " started.");
        if(t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
