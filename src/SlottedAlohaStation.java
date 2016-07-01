/**
 * Created by ali on 6/29/16.
 */
public class SlottedAlohaStation extends Thread {
    Thread t;
    String threadName;
    int stationNumber;
    int L, R;
    double rForStation, P;
    double X;
    int m;
    boolean sendTime;
    double frame;
    int[] collision;



    public SlottedAlohaStation(String threadName, int stationNumber, int l, int r, double rForStation, double p, int m) {
        this.threadName = threadName;
        this.stationNumber = stationNumber;
        L = l;
        R = r;
        this.rForStation = rForStation; // frame per second
        P = p;
        X = L/R;
        this.m = m;
        collision = new int[100];
        for(int i = 0; i < 100; i++) {
            collision[i] = 0;
        }
        frame = 0;
    }

    public void run() {
        int j = 0;
        while(j < 20) {
            try {
                sleep((long) Math.ceil(X*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(frame < 1) {
                //System.err.println("Station " + stationNumber + " has no packet to send! " + frame);
                frame += rForStation*X;
                j++;
                continue;
            }
            frame -= 1;
            System.out.println("Station " + stationNumber + " sent 1 packet! in slot " + j + "\t" + frame);
            collision[j]++;
            frame += rForStation*X;
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

    public int[] getCollision() {
        return collision;
    }
}
