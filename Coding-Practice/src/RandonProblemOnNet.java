public class RandonProblemOnNet {

    public String runningLengthEncoding(String input) {
        char fc = input.charAt(0);
        int count =-1;
            for (int i = 1 ; i < input.length() ; i++) {
            count++;
            if (input.charAt(i) != fc){
                fc = input.charAt(i+1);
                input = input.substring(0, i) + count+ input.substring(i);
            }
                count=0;

        }

        //append count to string;
        return input;
    }

    public String modify (String input) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] array = input.toCharArray();
        int count = 0;
        Character prev = null;
        for (char curr: array) {

            if (prev != null && curr != prev) {
                stringBuilder.append(prev);
                stringBuilder.append(count);
                count=0;
            }
            count++;
            prev = curr;
        }
        stringBuilder.append(prev);
        stringBuilder.append(count);

        return stringBuilder.toString();
    }

    public String twoPointerapproach(String input) {
        if (input == null) {
            return input;
        }

        if (input.isEmpty()) {
            return null;
        }

        if(input.length() == 1) {
            return input+1;
        }

        int p= 0;
        int c = 1;
        int count = 1;
        String output = "";

        while (c < input.length()) {
            if (input.charAt(p) != input.charAt(c)) {
                output +=input.charAt(p);
                output+=count;
                count = 0;
            }
            count++;
            p++;
            c++;
        }

        output +=input.charAt(p);
        output+=count;

        return output;
    }
    public static void main(String[] args) {
        //System.out.println(new RandonProblemOnNet().twoPointerapproach("wwwwaaadexxxxxxywww"));
        System.out.println(new RandonProblemOnNet().decToBin("1.2.3.4"));
    }

    private String decimalToBinary (int n) {
        int[] binaryNum = new int[1000];

        if (n == 0){
            return "0";
        }

        int i =0;
        while (n > 0) {
            binaryNum[i]  = n%2;
            n = n/2;
            i++;
        }

        String output = "";

        for (int j = i -1; j >= 0; j--) {

            output += binaryNum[j];
        }
        int length = 8;

        if (output.length() < 8) {
            int outputLength = output.length();
            int zerosToAdd = 8 - outputLength;
            String zero = "0";
            String temp = "";
            //00010001
            for (int k = 0; k< zerosToAdd; k++) {
                temp +=zero;
            }

            output = temp+output;
        }

        return output;
    }

    public String decToBin (String input) {
        //split my string bases on "." and conver to int[].

        String[] integersArray = input.split(".");
        int[] values = new int[243546];
        for (int i = 0; i < integersArray.length ; i++) {
            //if (integersArray[i])
            values[i] = Integer.parseInt(integersArray[i]);
        }
        //values
        String output = "";

        for (int i = 0; i < values.length; i++) {
            //for last value don't append the '.'
            if (i == values.length-1) {
                output += decimalToBinary(values[i]);
            }
            output += decimalToBinary(i)+".";

        }

        return output;

    }
}
