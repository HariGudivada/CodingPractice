package LeetCode;
/**
 * Leetcode problem 811
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisits {
    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainToCountMap = new HashMap<>();
        for (String domain : cpdomains) {
            String[] cpinfo = domain.split("\\s+");
            String[] frags = cpinfo[1].split("\\.");
            int count = Integer.parseInt(cpinfo[0]);
            String curr = "";
            for (int i = frags.length - 1; i >= 0; i--) {
                curr = frags[i] + (i < frags.length - 1 ? "." : "") + curr;
                domainToCountMap.put(curr, domainToCountMap.getOrDefault(curr, 0) + count);
            }
        }
        List<String> list = new ArrayList<>();
        for (String domain: domainToCountMap.keySet()){
            list.add(domainToCountMap.get(domain)+ " "+ domain);
        }

        return list;
    }

    public static void main(String[] args) {
        String[] arr = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        subdomainVisits(arr);
    }
}
