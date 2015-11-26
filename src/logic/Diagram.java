package logic;

/**
 * Created by eugeny on 26.11.2015.
 */
public class Diagram {
    private int[] data;

    public void setData(int[] data) {
        this.data = data;
    }

    public int[] getData() {
        return data;
    }

    public int sum() {
        int s = 0;
        for (int i = 0; i < data.length; i++) {
            s += data[i];
        }
        return s;
    }

    public int max() {
        int res = data[0];
        for (int i = 1; i < data.length; i++) {
            if (res<data[i]) {
                res = data[i];
            }
        }
        return res;
    }
}
