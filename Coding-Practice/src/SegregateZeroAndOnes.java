public class SegregateZeroAndOnes {
    public static int[] segregate(int[] arr) {
        int left = 0;
        int right =arr.length-1;
        while (left < right) {
            while (arr[left] == 0) {
                left++;
            }
            while (arr[right] == 1) {
                right--;
            }
            if(left < right && arr[left] > arr[right]) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,1,1,0,1,1,0};
        segregate(arr);
    }
}
