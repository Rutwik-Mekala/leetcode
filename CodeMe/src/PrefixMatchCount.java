//leetcode 2185
//You are given an array of strings words and a string pref.
//
//Return the number of strings in words that contain pref as a prefix.
//
//A prefix of a string s is any leading contiguous substring of s.

class PrefixMatchCount {
    public static void main(String[] args) {
        String[]  words = {"pay","attention","practice","attend"};
        String pref = "at";
        System.out.println(prefixCount(words,pref));
    }
    public static int prefixCount(String[] words, String pref) {
        int prefL = pref.length();
        int count = 0;
        for(int i=0; i<words.length; i++){
            if(words[i].length()<prefL) continue;
            String subs = words[i].substring(0,prefL);
            if(subs.equals(pref)) count++;
        }
        return count;
    }
}
