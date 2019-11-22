package MicrosoftPre;

import java.util.Arrays;
import java.util.TreeMap;

public class DineshMicrosoft {
    public int solution(int[] x, int[] y) {
        int xAxis = x[0];
        int area = 0;
        Arrays.sort(x);
        //Taking a HashMap that can sort based on the keys would help.
        for (int i = 1; i < x.length; i++) {
            area = Math.max(x[i] - xAxis, area);
            if (x[i] > xAxis) {
                xAxis = x[i];
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] x = {5,5,5,7,7,7};
        int[] y = {6,4,1,8,5,1,7};
        DineshMicrosoft dm = new DineshMicrosoft();
        dm.solution(x, y);
    }
}
