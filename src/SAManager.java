/**
 * Created by ali on 7/1/16.
 */
public class SAManager extends Thread{
    Thread t;
    String threadName;
    int L, R;
    double P;
    double X;
    int m;
    double[] rForStation;
    SlottedAlohaStation[] stations;
    int[] collision;

    public SAManager(int l, int r, double p, int m, double[] rForStation) {
        L = l;
        R = r;
        P = p;
        X = L/R;
        this.m = m;
        this.rForStation = rForStation;
        stations = new SlottedAlohaStation[m];
        threadName = "manager";
        collision = new int[100];
        for(int i = 0; i < 100; i++) {
            collision[i] = 0;
        }
        createSlottedStations();
    }

    void createSlottedStations() {
        System.out.println("Slotted Manager start.");
        for(int i = 0; i < m; i++) {
            stations[i] = new SlottedAlohaStation("station"+i, i, L, R, rForStation[i], P, m);
            stations[i].start();
        }
    }

    public void showCollisions() {
        try {
            sleep((long) Math.ceil(X*1000*30));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int[] tmpArr = new int[100];
        for(int j = 0; j < m; j++) {
            tmpArr = stations[j].getCollision();
            for (int i = 0; i < 20; i++) {
                collision[i] += tmpArr[i];
            }
        }
        for (int i = 0; i < 20; i++) {
            if (collision[i] > 1) {
                System.err.println("Collision occurred in slot " + i);
            }
        }
    }
}
