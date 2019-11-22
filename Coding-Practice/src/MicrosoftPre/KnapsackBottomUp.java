package MicrosoftPre;

public class KnapsackBottomUp {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int[][] dp = new int[profits.length][capacity + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0) {
                    if (j < weights[i]) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = profits[i];
                    }
                }
                if (j < weights[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-weights[i]], dp[i-1][j]);
                }
            }
        }
        return dp[profits.length-1][capacity];
    }

    public static void main(String[] args) {
        KnapsackTopDown ks = new KnapsackTopDown();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        int[]weights1 = {5, 3, 4, 2};
        int[]profits1 = {60, 50, 70, 30};
        System.out.println("Total knapsack profit ---> "+ ks.solveKnapsack(profits1, weights1, 5));
    }
}
