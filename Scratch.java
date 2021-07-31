import java.util.*;

class Scratch {
    public static void main(String[] args) {
        // https://www.hackerrank.com/challenges/pairs/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
        // Given an array of integers and a target value,
        // determine the number of pairs of array elements that have a difference equal to the target value.

        // ex 1
        int k = 1;
        List<Integer> arr;

        k = 1;
        arr = Arrays.asList(1, 2, 3, 4);
        // There are three values that differ by k:1 , 2-1=1, 3-2=1, and 4-3=1. Return 3.
        int r = pairs(k, arr);
        System.out.println("r = " + r);
    }

    public static int pairs(int k, List<Integer> arr) {
        int count = 0;


        // O(n^2)
        /*
        for (int i=0; i< arr.size(); i++){
            //count << "i "<< arr[i]<< endl;
            int a = arr.get(i);
            // printf("i:%d %d\n", i, a);
            for (int j=i; j< arr.size(); j++){
                int b = arr.get(j);
                if (a-b==k || b-a==k) {
                    System.out.printf("i:%d j:%d a:%d b:%d \n", i, j, a, b);
                    count++;
                }
            }
        }
        return count;
        */

        // O(n)
        // map of numbers and their counts so we handle duplicate numbers
        Set<Integer> occurs = new HashSet();
        // fill map w count of occurences
        for (int n : arr) {
            System.out.printf("n:%d \n", n);
            if (!occurs.contains(n)) {
                occurs.add(n);
            }
        }
        for (int n : arr) {
            if (!occurs.contains(n)) {
                continue;
            }
            System.out.printf("k:%d \n", n);
            int kplus = n + k;
            // look up, not down else gets dupes
            if (occurs.contains(kplus)) {
                System.out.printf("k:%d n+k %d \n", n, kplus);
                count++;
            }
        }
        return count;
    }

}
