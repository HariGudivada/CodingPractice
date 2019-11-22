import java.util.Map;
import java.util.TreeMap;

public class RelativeSortArray {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        Map<Integer, Integer> map = new TreeMap<>();

        for ( int i = 0; i < arr1.length ; i++) {
            map.computeIfAbsent(arr1[i], f -> 0);
            Integer integer = map.get(arr1[i]);
            map.put(arr1[i], ++integer);
        }

        int placeHolder =0;

        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                int count = map.get(arr2[i]);
                while (count>0) {
                    result[placeHolder] = arr2[i];
                    placeHolder++;
                    count--;
                }
                map.remove(arr2[i]);
            }
        }

        for (int key : map.keySet()) {
            int count = map.get(key);
            while (count > 0) {
                result[placeHolder] =  key;
                count--;
                placeHolder++;
            }
        }

        return result;
    }

    public static int[] relativeSortArrayOnlineSolution(int[] arr1, int[] arr2) {
        // Bucket for 0 <= arr element <= 1000
        int[] bucket = new int[1001];

        int[] result = new int[arr1.length];
        int index = 0;

        // Fill bucket
        for(int i : arr1) {
            bucket[i]++;
        }

        // First store result in order of arr2
        for(int i : arr2) {
            while(bucket[i]-- > 0) {
                result[index++] = i;
            }
        }

        // Fill remaining element
        for(int i = 0; i < 1001; i++){
            if(bucket[i] > 0) {
                while(bucket[i]-- > 0) {
                    result[index++] = i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
//        int[] arr1 = new int[]{2,1,6,5};
//        int[] arr2 = {1,2};
        for (int i : relativeSortArrayOnlineSolution(arr1, arr2)){
            System.out.println(i);
        }
    }

}
