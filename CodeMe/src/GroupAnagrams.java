//leetcode 49
//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
import java.util.*;
class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagramsEfficient(strs));
    }
    //following solution is very time-consuming and not recommended
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        boolean[] visited = new boolean[strs.length];
        for(int i=0; i<strs.length; i++){
            List<String> anagrams = new ArrayList<>();
            for(int j=i; j<strs.length; j++){
                if(!visited[j] && isAnagram(strs[i],strs[j])){
                    anagrams.add(strs[j]);
                    visited[j]=true;
                }
            }
            if(!anagrams.isEmpty()){
                result.add(anagrams);
            }
        }
        return result;

    }
    public static boolean isAnagram(String a, String b){
        if(a.length() != b.length()) return false;
        int[] count = new int[26];
        for(int i=0; i<a.length(); i++){
            count[a.charAt(i)-'a']++;
            count[b.charAt(i)-'a']--;
        }
        for(int i=0; i<26; i++){
            if(count[i]!=0) return false;
        }
        return true;
    }
    //more efficient better solution
    public static List<List<String>> groupAnagramsEfficient(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] hash = new char[26];
            for (char c : s.toCharArray()) {
                hash[c - 'a']++;
            }
            String key = new String(hash);
            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(s);
        }
        res.addAll(map.values());
        return res;
    }
}
