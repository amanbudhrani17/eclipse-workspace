import java.util.HashSet;

public class LongestRepeatedSubsequenceLengthProblem {
    public static void main(String[] args){
        String s1 = "AAKKTTA";
        System.out.println(Solution(s1));
    }
    public static int Solution(String s){
        int result = 0;
        HashSet<Character> a1 = new HashSet<>();
        HashSet<Character> a2 = new HashSet<>();
        for (int i = 0; i<s.length() ;i++){
            if (!a1.contains(s.charAt(i))){
                a1.add(s.charAt(i));
            }
            else {
                if (!a2.contains(s.charAt(i))){
                    a2.add(s.charAt(i));
                    result++;
                }
            }
        }
        return result;
    }
}
