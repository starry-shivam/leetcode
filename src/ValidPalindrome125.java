import utils.ExecDuration;

public class ValidPalindrome125 {

    // StringBuilder approach, uses extra space to store the cleaned string
    // Time: O(n), Space: O(n)
    public boolean isPalindrome1(String s) {
        if (s.isEmpty()) return true;
        char[] sCharArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : sCharArr) {
            if (Character.isAlphabetic(c)) {
                sb.append(Character.toLowerCase(c));
            }
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString().contentEquals(sb.reverse());
    }

    // Two pointers approach, uses constant space complexity (Faster than isPalindrome1)
    // Time: O(n), Space: O(1)
    public boolean isPalindrome2(String s) {
        if (s.isEmpty()) return true;
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            char currStart = s.charAt(start);
            char currEnd = s.charAt(end);

            if (!Character.isLetterOrDigit(currStart)) {
                start++;
            } else if (!Character.isLetterOrDigit(currEnd)) {
                end--;
            } else {
                if (Character.toLowerCase(currStart) != Character.toLowerCase(currEnd)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome125 obj = new ValidPalindrome125();
        String input1 = "A man, a plan, a canal: Panama";
        System.out.println(obj.isPalindrome1(input1)); // true
        System.out.println(obj.isPalindrome2(input1)); // true
        String input2 = "race a car";
        System.out.println(obj.isPalindrome1(input2)); // false
        System.out.println(obj.isPalindrome2(input2)); // false
        System.out.println("---------------------------------- ");
        System.out.println("ExecDuration for isPalindrome1: ");
        ExecDuration.measure(() -> obj.isPalindrome1(input1));
        ExecDuration.measure(() -> obj.isPalindrome1(input2));
        System.out.println("---------------------------------- ");
        System.out.println("ExecDuration for isPalindrome2: ");
        ExecDuration.measure(() -> obj.isPalindrome2(input1));
        ExecDuration.measure(() -> obj.isPalindrome2(input2));
    }
}
