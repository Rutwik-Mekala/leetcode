import java.util.ArrayDeque;

public class BalancedParanthesis {
    public static void main(String[] args) {
        String s = "{}([()])";
        System.out.println(isBalanced(s));
    }
    public static boolean isBalanced(String str){
        ArrayDeque<Character> s = new ArrayDeque<>();
        for(int i=0; i<str.length(); i++){
            char x = str.charAt(i);
            if(x=='(' || x=='{' || x=='['){
                s.push(x);
            }else{
                if(s.isEmpty()) return false;
                else if(!isMatching(s.pop(),x)){
                    return false;
                }
            }
        }
        return s.isEmpty();
    }
    public static boolean isMatching(char a, char b){
        return ((a=='(' && b==')') || (a=='[' && b==']') || (a=='{' && b=='}'));
    }
}
