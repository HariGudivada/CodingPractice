package Misc;

import java.util.*;
//Dinesh's VMware hacker rank coding assessment.
public class Solution {
    private  static Response validateInput(List<Integer> inputs) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(int input : inputs)
        {
            pq.offer(input);
        }

        int expected = pq.peek();
        int received = inputs.size();
        boolean status = false;

        if(expected == received)
            status = true;

        return new Response(status, received, expected);
    }
    static class Response
    {
        boolean status;
        int recieved;
        int expected;
        Response(boolean status, int recieved, int expected)
        {
            this.status = status;
            this.recieved = recieved;
            this.expected = expected;
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String[] cItems = scanner.nextLine().split(" ");
            List<Integer> list = new ArrayList<>(cItems.length);
            for (int j = 0 ; j < cItems.length; i++) {
                if (!Character.isDigit(cItems[j].charAt(0))) {
                    System.out.println("FAILURE => WRONG INPUT (LINE "+ i);
                    list.clear();
                    break;
                } else {
                    list.add(Integer.parseInt(cItems[i]));
                }
            }
            Response response = validateInput(list);
            StringBuilder sb = new StringBuilder();
            sb.append(response.status ? "SUCCESS => " : "FAILURE => ");
            sb.append("RECEIVED: " + response.recieved);
            if(!response.status)
                sb.append(", EXPECTED: " + response.expected);
            System.out.println(sb.toString());
        }
    }
}
