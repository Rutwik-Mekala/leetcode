//leetcode 2186
//You are given two strings s and t. In one step, you can append any character to either s or t.
//
//Return the minimum number of steps to make s and t anagrams of each other.
//
//An anagram of a string is a string that contains the same characters with a different (or the same) ordering.
class StepsToAnagram {
    public static void main(String[] args) {
        String s = "leetcode";
        String t = "coats";
        System.out.println(minSteps(s,t));
    }
    public static int minSteps(String s, String t) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int res=0;
        for(int i=0; i<s.length(); i++){
            count1[s.charAt(i)-'a']++;
        }
        for(int i=0; i<t.length(); i++){
            count2[t.charAt(i)-'a']++;
        }
        for(int i=0; i<26; i++){
            if(count1[i]==count2[i]){
                continue;
            }else{
                res+=Math.abs(count1[i]-count2[i]);
            }
        }
        return res;
    }
}
