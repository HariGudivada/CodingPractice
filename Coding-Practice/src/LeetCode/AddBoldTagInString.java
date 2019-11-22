package LeetCode;

import java.util.*;

/**
 * 616
 */
public class AddBoldTagInString {
    public static String addBoldTagTry(String s, String[] dict) {
        StringBuilder sb = new StringBuilder(s);
        String openTag = "<b>";
        String closeTag = "</b>";

        for (int i = 0 ; i < dict.length; i++) {
            int index = s.indexOf(dict[i]);
            if (index != -1) {
                sb.insert(index, openTag);
                sb.insert(index+dict[i].length()+3, closeTag);

            }
        }

        return s;
    }

    public class interval{
        int start;
        int end;
        interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public String addBoldTag(String s, String[] dict) {
        List <interval> list = new ArrayList<>();
        for (String str : dict) {
            int index = s.indexOf(str);
            while (index != -1) {
                list.add(new interval(index, index+str.length()));
                index = s.indexOf(str, index+1);
            }
        }
        Collections.sort(list,new Comparator<interval>(){
            public int compare(interval a,interval b){
                return a.start-b.start;
            }
        });
        List<interval> res = mergeInterval(list);

        int prev = 0;
        StringBuilder sb = new StringBuilder();
        for (interval interval : res) {
            sb.append(s.substring(prev, interval.start));
            sb.append("<b>" + s.substring(interval.start, interval.end) + "</b>");
            prev = interval.end;
        }
        if (prev < s.length()) {
            sb.append(s.substring(prev));
        }

        return sb.toString();
    }

    public List<interval> mergeInterval(List<interval> list){
        List<interval> res = new ArrayList<>();
        if(list==null || list.size()==0){
            return res;
        }
        res.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            interval curr = list.get(i);
            interval prev = res.get(res.size() - 1);
            if (curr.start > prev.end) {
                res.add(curr);
            } else {
                int max = Math.max(prev.end, curr.end);
                prev.end = max;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        AddBoldTagInString addBoldTagInString = new AddBoldTagInString();
        String s = "aaabbcc";
        String[] dict = {"aaa","aab","bc"};
        addBoldTagInString.addBoldTag(s, dict);
    }
}
