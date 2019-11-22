package GrokkingCodingInterview.TopologicalSort;

import java.util.*;

public class AlienDictionary {
    public static String findOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        Map<Character, List<Character>> map = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for (String word : words) {
            for (int i = 0 ; i < word.length(); i++) {
                map.put(word.charAt(i), new ArrayList<>());
                inDegree.put(word.charAt(i), 0);
            }
        }

        for (int i =0; i < words.length-1; i++) {
            String firstWord = words[i], secondWord = words[i+1];
            for (int j = 0 ; j < Math.min(firstWord.length(), secondWord.length()); j++) {
                char parent = firstWord.charAt(j), child = secondWord.charAt(j);
                if (parent != child) {
                    map.get(parent).add(child);
                    inDegree.put(child, inDegree.get(child)+1);
                    break;
                }
            }
        }

        Queue<Character> sources = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!sources.isEmpty()) {
            Character source = sources.poll();
            sb.append(source);
            List<Character> childs = map.get(source);
            for (Character child : childs) {
                inDegree.put(child, inDegree.get(child)-1);
                if (inDegree.get(child) == 0){
                    sources.offer(child);
                }
            }
        }

        return sb.toString();
    }
}
