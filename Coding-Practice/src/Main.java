//package com.javaprograms;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        // given test cases
//        int[] a = {1,2,3,3};
//        int[] b = {2,3,1,4};
//        int n = 4;
//        System.out.println(solution(a,b,n));
//
//        a = new int[]{1,2,4,5};
//        b = new int[]{2,3,5,6};
//        n = 6;
//        System.out.println(solution(a,b,n));
//
//        // edge cases
//        a = new int[]{1,2,3,4};
//        b = new int[]{5,6,7,8};
//        n = 8;
//        System.out.println(solution(a,b,n));
//
//        a = new int[]{};
//        b = new int[]{};
//        n = 1;
//        System.out.println(solution(a,b,n));
//    }
//
//    private static String[] ToStrArr(int[] arr)
//    {
//        String[] res = new String[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            res[i] = Integer.toString(arr[i]);
//        }
//        return  res;
//    }
//
//    public static int solution(int[] A,int[] B, int N )
//    {
//        String[] a = ToStrArr(A);
//        String[] b = ToStrArr(B);
//        HashMap<String, ArrayList<String>> map = BuildGraphMap(a,b,N);
//
//        if(N == 0 || N == 1) return 0;
//
//        String MaxAEle = "";
//        String MaxBEle = "";
//        int maxLen = 0;
//        for (String key : map.keySet())
//        {
//            String aElementKey = key;
//            ArrayList<String> aEleList = map.get(key);
//            int len = aEleList.size();
//            for(String aElement : aEleList)
//            {
//                int aElementLen = map.get(aElement).size()-1;
//                if(aElementLen + len > maxLen)
//                {
//                    maxLen = aElementLen + len;
//                    MaxAEle = key;
//                    MaxBEle = aElement;
//                }
//            }
//        }
//        return maxLen;
//    }
//
//    private static HashMap<String, ArrayList<String>> BuildGraphMap(String[] a, String[] b, int n)
//    {
//        HashMap<String, ArrayList<String>> fullMap = new HashMap<>();
//        for (int i = 0; i <a.length; i++) {
//            AddToHashMapIfNotExists(fullMap,a[i],b[i]);
//            AddToHashMapIfNotExists(fullMap,b[i],a[i]);
//        }
//
//        return fullMap;
//    }
//
//    private static void AddToHashMapIfNotExists(HashMap<String,ArrayList<String>> mapToAdd, String key, String val)
//    {
//        if(mapToAdd.containsKey(key))
//        {
//            mapToAdd.get(key).add(val);
//        }
//        else
//        {
//            ArrayList temp = new ArrayList();
//            temp.add(val);
//            mapToAdd.put(key, temp);
//        }
//    }
//}
