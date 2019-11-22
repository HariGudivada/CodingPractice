package LeetCode;

public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 0) {
            return n <= 1;
        }
        int numFlowersCanPlace = 0;
        int currZeroes = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (i > 0 && flowerbed[i - 1] == 1) {
                    currZeroes = -1;
                }
                currZeroes++;
            } else if (currZeroes != 0) {
                numFlowersCanPlace += (currZeroes / 2);
                if (numFlowersCanPlace >= n) {
                     return true;
                }
                currZeroes = 0;
            }
        }
        numFlowersCanPlace += (currZeroes + 1) / 2;
        return numFlowersCanPlace >= n;
    }

    public static boolean canPlaceFlowersPractice(int[] flowerbed, int n) {
        int numberOfFlowersPlaced = 0;
        int zeroCount = 0;
        for (int i = 0 ; i < flowerbed.length ; i++) {
            if (flowerbed[i] == 0) {
                if (i > 0 && flowerbed[i-1] == 1) {
                    zeroCount =-1;
                }
                zeroCount++;
            } else if (zeroCount != 0) {
                numberOfFlowersPlaced +=  (zeroCount/2);
                if (numberOfFlowersPlaced >= n) {
                    return true;
                }
                zeroCount = 0;
            }
        }

        numberOfFlowersPlaced += (zeroCount+1)/2;
        return numberOfFlowersPlaced >= n;
    }

    public static void main(String[] args) {
        int[] arr ={1,0,0,0,0,1,0,1,0};
        canPlaceFlowers(arr, 1);
    }
}
