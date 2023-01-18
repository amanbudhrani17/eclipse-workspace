import java.util.HashSet;

public class LongestCommonSubsequenceLengthProblemUsingBottomsUp {
    public static void main(String[] args){
        System.out.println(Solution("catc","catc"));
    }
    public static int Solution(String s1, String s2){

        int[][] a = new int[s1.length()+1][s2.length()+1];
        for (int index1 = s1.length();index1>0;index1--){
            for (int index2 = s2.length();index2>0;index2--) {
                if (s1.charAt(index1-1) == s2.charAt(index2-1)) {
                    a[index1-1][index2-1] = Math.max(1+a[index1][index2], Math.max(a[index1-1][index2], a[index1][index2-1]));
                }
                else {
                    a[index1-1][index2-1] = Math.max(a[index1-1][index2], a[index1][index2-1]);
                }
            }
        }
        return a[0][0];
    }
}
