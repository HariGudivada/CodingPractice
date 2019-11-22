//package MicrosoftPre;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
////1209
//public class RemoveAllAdjacentDuplicatesInStringII {
//    public String removeDuplicates2(String s, int k) {
//        if (s == null || s.length() < k) {
//            return s;
//        }
//
//        removeKCharacters(s, k);
//    }
//
//    private String removeKCharacters(String s, int k) {
//        if (s == null || s.length() < k) {
//            return s;
//        }
//
//        int start = 0;
//        int end =0;
//        List<List<Integer>> points = new ArrayList<>();
//        while (end < s.length()) {
//            if (s.charAt(start) == s.charAt(end)) {
//                while (s.charAt(start) == s.charAt(end)) {
//                    if (end-start+1 >= k) {
//                        List<Integer> list = Arrays.asList(start, end);
//                        points.add(list);
//                    }
//                    end++;
//                }
//                start = end;
//            }
//        }
//        s = remove(s, points);
//    }
//
//    public String remove(String s, List<List<Integer>> points) {
//        if (s.length() == 0) {
//            return s;
//        }
//        List<Integer> list1 = points.get(0);
//        String result = "";
//        int start = list1.get(0)-1;
//        int end =
//        for (List<Integer> list : points) {
//            String start = list.get(0) > 0 ? s.substring(result.length()-1, list.get(0)) : "";
//            String end = list.get(1)+1 < s.length() ? s.substring(list.get(1)+1, s.length()) : "";
//            result = start+end;
//        }
//    }
//}
