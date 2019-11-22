//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.PriorityQueue;
//import java.util.Set;
//
//public class StringContains {
//
////    public static void main(String[] args) {
////        String thisLine = null;
////        String s = "";
////        String t = "";
////        int count = 0;
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        while ((thisLine = br.readLine()) != null) {
////            System.out.println(thisLine);
////            String[] input = thisLine.split("=");
////            if (count == 0) {
////                s = input[1];
////            } else {
////                t = input[1];
////            }
////        }
////        if(s == null || s.isEmpty()) {
////            throw new IllegalArgumentException();
////        }
////
////        String givenS =  s.toLowerCase();
////        String words[] =  t.split(" ");
////
////        for (String word : words) {
////            if (s.indexOf(word.toLowerCase()) >= 0) {
////                System.out.println("true");
////            } else {
////                System.out.println("false");
////            }
////        }
////    }
////
////    private static void printOutput(String s, String t) {
////        String givenS =  s.trim().toLowerCase();
////        String words[] =  t.trim().split(" ");
////
////        for (String word : words) {
////            if (s.indexOf(word.toLowerCase()) >= 0) {
////                System.out.println(true);
////            } else {
////                System.out.println(false);
////            }
////        }
////    }
////
////    public static void main(String[] args) {
////        String s = "abcdefghijkl";
////        String t = "ab dinesh def cd abcd";
////        printOutput(s, t);
////    }
//
//    public static int[][] highFive(int[][] items) {
//        LinkedHashMap<Integer, PriorityQueue> map = new LinkedHashMap<>();
//
//        for (final int[] internalArray : items) {
//            if (map.containsKey(internalArray[0])) {
//                final PriorityQueue<Integer> queue = map.get(internalArray[0]);
//                Integer valueToAdd = internalArray[1];
//                if (queue.size()>= 5) {
//                    final Integer minElement = queue.remove();
//
//                    if (valueToAdd < minElement) {
//                       valueToAdd = minElement;
//                    }
//                }
//                queue.add(valueToAdd);
//            } else {
//                final PriorityQueue<Integer> queue = new PriorityQueue(5);
//                queue.add(internalArray[1]);
//                map.put(internalArray[0], queue);
//            }
//        }
//
//        final Set<Integer> integers = map.keySet();
//        final int[][] result = new int[integers.size()][integers.size()];
//        int i = 0;
//        Integer sum = 0;
//        for ( Integer key : integers) {
//            final Iterator<Integer> iterator = map.get(key).iterator();
//
//            while (iterator.hasNext()) {
//                sum += iterator.next();
//            }
//            result[i][0] =  key;
//            result[i][1] =  sum/5;
//            sum =0;
//            i++;
//        }
//
//        return result;
//    }
//
//    public static void main(String[] args) {
//        int[][] input = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
//        final int[][] studentAvg = getStudentAvg(input);
//        System.out.println(studentAvg);
//    }
//}
