package LeetCode;

public class DietPlanPerformance {
    public static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int s = 0;
        int e = k-1;
        int result = 0;
        int sum =0;
        while (s <= e) {
            sum += calories[s];
            s++;
        }
        s = 0;
        while (s < calories.length-k+1) {
            if (sum < lower) {
                result--;
            }

            if (sum > upper) {
                result++;
            }

            sum -= calories[s];
            s++;
            if (e+1 < calories.length) {
                sum += calories[e+1];
                e++;
            }

        }

        return result;

    }

    public static void main(String[] args) {
        int[] a = {6,5,0,0};
        int k = 2;
        int l =  1;
        int u = 5;
        dietPlanPerformance(a, k, l, u);
    }
}
