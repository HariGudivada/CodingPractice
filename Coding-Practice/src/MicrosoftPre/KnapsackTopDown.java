package MicrosoftPre;

import java.util.Arrays;
//https://www.youtube.com/watch?v=xCbYmUPvc2Q - back to back swe
public class KnapsackTopDown {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int [][] dp = new int[profits.length][capacity + 1];
        for (int[] arr :dp) {
            Arrays.fill(arr, -1);
        }
        return this.knapsackRecursive(dp, profits, weights, profits.length-1, capacity);
    }

    private int knapsackRecursive(int[][] dp, int[] profits, int[] weights, int items, int capacity) {
        if (items < 0 || capacity < 0) {
            return 0;
        }
        if(dp[items][capacity] != -1) {
            return dp[items][capacity];
        }
        if (weights[items] > capacity) {
            return knapsackRecursive(dp, profits, weights, items-1, capacity);
        }
        dp[items][capacity] = Math.max(knapsackRecursive(dp, profits, weights, items-1, capacity-weights[items]) + profits[items] ,knapsackRecursive(dp, profits, weights, items-1, capacity));

        return dp[items][capacity];
    }

    public static void main(String[] args) {
//        int  weights [] = {5,3,4,2};
//        int[] profits = {60,50,70,30};
//        Knapsack knapsack = new Knapsack();
//        knapsack.solveKnapsack(profits, weights, 5);

        KnapsackTopDown ks = new KnapsackTopDown();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
