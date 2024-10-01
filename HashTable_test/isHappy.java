package HashTable_test;
//快乐数
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class isHappy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Solution.isHappy(n));
    }

    class Solution {
        public static boolean isHappy(int n) {
            Set<Integer> record = new HashSet<>();//
            while (n != 1 && !record.contains(n)) {
                record.add(n);
                n = getNextNumber(n);
            }
            return n == 1;
        }

        private static int getNextNumber(int n) {
            int res = 0;
            while (n > 0) {
                int temp = n % 10;
                res += temp * temp;
                n = n / 10;
            }
            return res;
        }
    }
}


