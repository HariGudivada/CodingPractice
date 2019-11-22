import java.util.Arrays;

class PrisonProblem {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if (N == 0) {
            return cells;
        }

        if(cells.length == 1) {
            return new int[] {0};
        }

        if (cells.length == 2 && N > 0) {
            return new int[] {0,0};
        }

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
            System.out.println(Arrays.toString(cells));
            N-=1;

        }



        return cells;
    }


    public static void main(String[] args) {
        int[] cells = new int[]{0,1,0,1,1,0,0,1};
        int N = 7;
        PrisonProblem prisonProblem = new PrisonProblem();
        prisonProblem.prisonAfterNDays(cells, N);
    }
}