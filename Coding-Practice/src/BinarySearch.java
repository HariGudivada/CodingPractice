public class BinarySearch {

    public boolean binarySearchIterative (int[] array, int x) {
        int left = 0;
        int right = array.length;

        int mid = left + (right - left)/2;

        while (left <= right) {
            if (array[mid] == x) {
                return true;
            } else if (x < array[mid]){
                right = mid-1;
            } else {
                left = mid +1;
            }
        }

       return false;
    }

    private boolean binarySearchRecursive (int[] array, int x, int left, int right) {
        if (left > right){
            return false;
        }

        int mid = left + (right - left)/2;

        if (array[mid] == x) {
            return true;
        }
        else if (array[mid] < x) {
            return binarySearchRecursive(array, x, mid+1, right);
        }
        else {
            return binarySearchRecursive(array, x, left, mid-1);
        }
    }

}
