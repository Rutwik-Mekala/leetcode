//leetcode 125
//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//
//Given a string s, return true if it is a palindrome, or false otherwise.
class ValidPalindrome {
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }
    //Takes more than 1 sec to execute. Not the best solution
    public static boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        String word = "";
        for(char c: str.toCharArray()){
            if((c>='a' && c<='z') || (c>='0' && c<='9')){
                word+=c;
            }
        }
        System.out.println(word);
        return checkPalindrome(word);
    }
    public static boolean checkPalindrome(String word){
        Character st = word.charAt(0);
        int low = 0;
        int high = word.length()-1;
        while(low<=high){
            if(word.charAt(low)!=word.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
    //better more recommended solution
    public static boolean isPalindromeEfficient(String s) {

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {

            Character start = s.charAt(i);
            Character end = s.charAt(j);

            if (!Character.isLetterOrDigit(start)) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(end)) {
                j--;
                continue;
            }

            if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
