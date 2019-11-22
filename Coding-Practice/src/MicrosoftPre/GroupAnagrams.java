package MicrosoftPre;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Set<Integer> indexSet = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if(indexSet.contains(i)) {
                continue;
            }
            List<String> list = new ArrayList<>();
            int[] arr = new int[26];
            for (int k = 0; k < strs[i].length(); k++) {
                arr[strs[i].charAt(k) - 'a']++;
            }
            list.add(strs[i]);
            for (int j = i+1; j < strs.length; j++) {
                if (indexSet.contains(j)) {
                    continue;
                }
                int[] temp = arr.clone();
                if(strs[i].length() == strs[j].length() && isAnagram(strs[j], temp)) {
                    indexSet.add(j);
                    list.add(strs[j]);
                }
            }
            result.add(list);
        }

        return result;

    }

    private boolean isAnagram(String s1, int[] temp) {
        for (int i =0; i < s1.length(); i++) {
            temp[s1.charAt(i)-'a']--;
            if (temp[s1.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.groupAnagrams(arr);
    }
}
