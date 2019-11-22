import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class PrisonProblem2 {


    private static int[] prisonAfterGiveDays(int[] cells, int N) {
        while(N != 0) {
            int[] copy = Arrays.copyOf(cells, cells.length);
            for (int i = 1; i <= cells.length-2 ; i ++) {
                if( cells[i-1] == cells[i+1]) {
                    copy[i] = 1;
                } else {
                    copy[i] = 0;
                }
            }
            copy[0] = 0;
            copy[copy.length -1] = 0;
            cells = copy;
            N-=1;

        }

        return cells;
    }

    public static int calculateCycleNumber(int[] cells) {
        Set<String> set = new HashSet<>();
        int N=0;
        int[] arr = cells;
        //set.add(Arrays.toString(arr));
        while(N<=256) {
            int[] newState = prisonAfterGiveDays(arr, 1);
            String key = Arrays.toString(newState);

            if(set.contains(key)) return N;

            set.add(key);
            N++;
            arr = newState;
        }

        return N;
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        if (N == 0) {
            return cells;
        }

        if(cells.length == 1) {
            return new int[] {0};
        }

        if (cells.length == 2 && N > 0) {
            return new int[] {0,0};
        }

        int t = calculateCycleNumber(cells);
        int result = N%t;
        return prisonAfterGiveDays(cells, result);
    }

    public static void main(String[] args) {
        int[] cells = {0,1,0};
        int N = 1000000000;
        System.out.println(prisonAfterGiveDays(cells,6));
        System.out.println(calculateCycleNumber(cells));
    }

}