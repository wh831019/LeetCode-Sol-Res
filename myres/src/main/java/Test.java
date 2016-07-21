import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by allen on 16/6/28.
 */
public class Test {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
//            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    System.out.println(i + " " + j + "   " + k);
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                }
            }
//            }

        }
        System.out.println(list.toString());
        return list;
    }

    public int myAtoi(String str) {
        int result = 0;
        int flag = 1;
        int index = 0;

        if (str.length() == 0) {
            return 0;
        }

        for (; str.charAt(index) == ' '; index++) ;

        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            flag = str.charAt(index) == '-' ? -1 : 1;
            index++;
        }

        int add = 0;
        for (; index < str.length(); index++) {
            if (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                add = Integer.parseInt(String.valueOf(str.charAt(index)));
                if (Integer.MAX_VALUE / 10 < result || Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < add) {
                    return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = result * 10 + add;
            } else {
                break;
            }
        }
        System.out.println(result * flag);
        return result * flag;

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }

            } else if (s.charAt(i) == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }

            } else if (s.charAt(i) == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }

            } else {
                stack.push(s.charAt(i));

            }
        }

        return stack.isEmpty();
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double result = 1;
        if (n < 0) {
            x = 1 / x;
            if (n == Integer.MIN_VALUE) {
                if (x >= 1) {
                    return 1;
                } else {
                    return 0;
                }
            }
            n = -n;

        }
        if (n == 1) {
            return x;
        }

        if (n % 2 == 0) {
            result = myPow(x * x, n / 2);
        } else {
            result = x * myPow(x * x, n / 2);
        }

        return result;
    }

    List<String> list = new ArrayList<String>();

    public void backTrack(String s, int l) {
        if (l == s.length()) {
            System.out.println(list.toString());
        }
        for (int i = l; i < s.length(); i++) {
            if (isPalindrome(s.substring(l, i + 1))) {
                list.add(s.substring(l, i + 1));
                backTrack(s, i + 1);
                list.remove(list.size() - 1);
            }
        }

    }

    public boolean isPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;
        System.out.println(s);
        while(head < tail){
            if(s.charAt(head) != s.charAt(tail)){
                return false;
            }else{
                head++;
                tail--;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Test test = new Test();
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        test.threeSum(nums);

//        test.myAtoi("2147483648");

//        test.isValid("([])");

        test.backTrack("aab", 0);
    }

}
