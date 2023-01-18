
import java.util.Iterator;

public class LongestCommonSubsequenceString {
    public static void main(String[] args){
        System.out.println(Solution("ABBDAB","BDCABA"));
    }
    public static char[] Solution(String s1, String s2){
        String str = "";
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
        int i = 0;
        int j = 0;
        char[] c = new char[a[0][0]];
        int index = 0;
        while (i < s1.length() && j < s2.length()){
            if (s1.charAt(i) == s2.charAt(j)){
                c[index] = s1.charAt(i);
                i++;
                j++;
                index++;
            }
            else if (a[i+1][j] > a[i][j+1]){
                i++;
            }
            else j++;
        }
        return c;
    }
}
