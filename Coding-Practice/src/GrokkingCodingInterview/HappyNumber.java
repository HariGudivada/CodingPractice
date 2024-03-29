package GrokkingCodingInterview;

public class HappyNumber {
    public static boolean find(int num) {
        int slow = num;
        int fast = num;
        while (slow != fast) {
            slow = findSquareSum(num);
            fast = findSquareSum(findSquareSum(num));
        }

        return slow ==1;
    }

    private static int findSquareSum(int num) {
        int sum = 0;
        int digit;
        while (num > 0) {
            digit = num % 10;
            sum += digit * digit;
            num = num/10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
//        System.out.println(HappyNumber.find(12));
    }
}
