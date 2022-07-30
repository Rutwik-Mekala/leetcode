import java.util.*;
class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(answer1(s,t));
    }
    public static boolean answer1(String s,String t){
        if(s.length()!=t.length()) return false;
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for(int i=0; i<26; i++){
            if(count[i]!=0) return false;
        }
        return true;
    }
}
