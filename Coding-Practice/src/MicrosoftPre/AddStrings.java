package MicrosoftPre;

public class AddStrings {
    public String addStrings(String num1, String num2) {

        int m = num1.length();
        int n = num2.length();
        if (m * n == 0) {
            return m == 0 ? num2 : num1;
        }
        m = m-1;
        n = n -1;
        int carry  = 0;
        StringBuilder result = new StringBuilder();
        int sum = 0;
        while (m >= 0 && n >= 0 ) {
            sum = Character.getNumericValue(num1.charAt(m)) + Character.getNumericValue(num2.charAt(n))+ carry;
            result.insert(0,sum%10);
            carry = sum/10;
            m--;
            n--;
        }
        if (m < 0) {
            while (n >=0) {
                sum = Character.getNumericValue(num2.charAt(n)) + carry;
                result.insert(0, sum%10);
                carry = sum/10;
                n--;
            }
        } else {
            while (m >=0) {
                sum = Character.getNumericValue(num1.charAt(m)) + carry;
                result.insert(0, sum%10);
                carry = sum/10;
                m--;
            }
        }

        if (carry > 0) {
            result.insert(0, carry);
        }

        return result.toString();
    }
}
