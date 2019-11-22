import java.sql.SQLOutput;
import java.util.Arrays;

public class QuickSortPractice {

    public int[] quickSort(int[] array) {
         quickSort(array, 0, array.length-1);
         return array;
    }

    private void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = array[(left +right)/2];
        int index = partition(array, left, right, pivot) ;
        quickSort(array, left, index-1);
        quickSort(array, index, right);

    }

    private int partition(final int[] array,  int left,  int right, final int pivot) {
        while(left <= right) {
            while (array[left] < pivot) {
                left++;
            }

            while (array[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap(final int[] array, final int left, final int right) {
        int temp = array[left];
        array[left] =  array[right];
        array[right] =  temp;
    }

    public static void main(String[] args) {
//        int[] array = {45,56,234,24657,23457,4657,4562,1,7,4,3,7};
        int[] array = {45,5,32};
        QuickSortPractice quickSortPractice = new QuickSortPractice();
        quickSortPractice.quickSort(array);
        for(int i : array) {
            System.out.println(i);
        }
    }
}
