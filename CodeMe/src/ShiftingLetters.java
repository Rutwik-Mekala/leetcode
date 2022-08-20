import java.util.HashMap;
//leetcode 2381 Shifting Letter 2
public class ShiftingLetters {
    public static void main(String[] args) {
        String s = "abc";
        int[][] shifts = {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}};
        String ans = getAnswer(s, shifts);
        System.out.println(ans);
    }

    public static String getAnswer(String s, int[][] shifts) {
        char[] alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        HashMap<Character, Integer> m = new HashMap<>();
        int c = 0;
        for (char ch = 'a'; ch <= 'z'; ++ch)
            m.put(ch, c++);
        StringBuilder newStr = new StringBuilder(s);
        for (int i = 0; i < shifts.length; i++) {
            int si = shifts[i][0];
            int ei = shifts[i][1];
            int dir = shifts[i][2];
            for (int j = 0; j < newStr.length(); j++) {
                if (dir == 0) {
                    //decrement si to ei
                    while (si <= ei) {
                        char a = newStr.charAt(si);
                        newStr.setCharAt(si, alphabets[((m.get(a) - 1) + 26) % 26]);
                        si++;
                    }

                } else {
                    //increment si to ei
                    while (si <= ei) {
                        char a = newStr.charAt(si);
                        newStr.setCharAt(si, alphabets[((m.get(a) + 1) + 26) % 26]);
                        si++;
                    }
                }
            }
        }
        return newStr.toString();
    }
}
