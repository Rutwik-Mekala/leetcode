//leetcode 242
import java.util.*;
class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(answer2(s,t));
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
    public static boolean answer2(String s,String t){
        if(s.length()!=t.length()) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i=0; i<s.length(); i++){
            count1[s.charAt(i)-'a']++;
            count2[t.charAt(i)-'a']++;
        }
        for(int i=0; i<26; i++){
            if(count1[i]!=count2[i]) return false;
        }
        return true;
    }
}
