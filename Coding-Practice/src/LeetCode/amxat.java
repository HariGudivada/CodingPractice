package LeetCode;

import java.util.*;

public class amxat {
    public static List<List<String>> threeProductSuggestions(int numProducts, List<String> repository, String customerQuery) {
        if (repository == null || repository.isEmpty() || numProducts <= 0 || customerQuery == null || customerQuery.length() < 2) {
            return Collections.emptyList();
        }

        ListIterator<String> iterator = repository.listIterator();
        while (iterator.hasNext())
        {
            String convertedString = iterator.next().toLowerCase().trim();
            if (!convertedString.isEmpty()) {
                iterator.set(convertedString);
            }
        }

        List<List<String>> result  = new ArrayList<>();
        //If we don't want to modify the given repository we can make a copy of it.
        List<String> repoCopy = repository;
        for (int i = 2 ; i<= customerQuery.length(); i++) {
            List<String> list = new ArrayList<>();
            for (String product : repoCopy){
                if(product.startsWith(customerQuery.substring(0, i))) {
                    list.add(product);
                }
            }

            repoCopy.clear();
            Collections.sort(list);
            repoCopy.addAll(list);
            int subListSize = Math.min(3, repoCopy.size());
            Set<String>  set = new HashSet<>(subListSize);
            for (int j = 0; j < subListSize; j++) {
                set.add(repoCopy.get(j));
            }
            if (!set.isEmpty()) {
                List<String> subList = new ArrayList<>(set.size());
                subList.addAll(set);
                result.add(subList);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> repo = new ArrayList<>(Arrays.asList("starbucks", "STARBUCKS", "startreck", "star", "startup", "steward"));
        String query ="star";
        int num = 5;
        List<List<String>> lists1 = threeProductSuggestions(num, repo, query);

    }
}
