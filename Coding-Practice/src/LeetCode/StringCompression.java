package LeetCode;

public class StringCompression {
    public int compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

    public static int compressArrayInplace(char[] chars) {
        if (chars.length <2) {
            return 1;
        }
        int countPlace = 1;
        int count = 1;
        int charPointer = 1;
        while (countPlace < chars.length && charPointer < chars.length) {
            if (chars[charPointer - 1] == chars[charPointer]) {

                count++;
            } else if (count >1){
                char[] numbers = Integer.toString(count).toCharArray();
                for (char c :  numbers) {
                    chars[countPlace] = c;
                    countPlace++;
                }
                count = 1;
                countPlace++;
            }
            charPointer++;
        }
        if(countPlace < chars.length && count >1) {
            char[] numbers = Integer.toString(count).toCharArray();
            for (char c :  numbers) {
                chars[countPlace] = c;
                countPlace++;
            }
        }

        return countPlace-1;
    }


    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        char[] charArr = {'a','a','b','b','b','b','b','b','b','b','b','b','b','b'};
        compressArrayInplace(charArr);
    }
}
