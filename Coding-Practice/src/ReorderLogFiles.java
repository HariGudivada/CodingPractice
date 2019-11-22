import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReorderLogFiles {
    //Question: https://leetcode.com/problems/reorder-log-files/
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            return sort(log1, log2);
        });
        return logs;
    }

    private int sort(final String log1, final String log2) {
        String[] split1 = log1.split(" ", 2);
        String[] split2 = log2.split(" ", 2);
        boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
        boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
        if (!isDigit1 && !isDigit2) {
            int cmp = split1[1].compareTo(split2[1]);
            if (cmp != 0) return cmp;
            return split1[0].compareTo(split2[0]);
        }
        return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
    }

    public static String[] reorderLogFilesSolution2(String[] logs) {
        if (logs == null || logs.length == 0) return logs;
        int len = logs.length;
        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();
        for (String log : logs) {
            if (log.split(" ")[1].charAt(0) < 'a') {
                digitList.add(log);
            } else {
                letterList.add(log);
            }
        }
        Collections.sort(letterList, (o1, o2) -> {
            String[] s1 = o1.split(" ");
            String[] s2 = o2.split(" ");
            int len1 = s1.length;
            int len2 = s2.length;
            final int min = Math.min(len1, len2);
            for (int i = 1; i < min; i++) {
                if (!s1[i].equals(s2[i])) {
                    return s1[i].compareTo(s2[i]);
                }

                if (i == min-1) {
                    return s1[0].compareTo(s2[0]);
                }
            }
            return 0;
        });

        for (int i = 0; i < len; i++) {
            if (i < letterList.size())
                logs[i] = letterList.get(i);
            else logs[i] = digitList.get(i - letterList.size());
        }
        return logs;
    }

    public static void main(String[] args) {
//        String[] input = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        String[] input = {"g1 act car","ab1 off key dog","a8 act zoo","a2 act car"};
        System.out.println(reorderLogFilesSolution2(input).toString());
    }
}
