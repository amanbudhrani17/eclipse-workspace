public class LongestCommonSubsequenceLengthproblemUsingTopDown {
    public static void main(String[] args){
        String s1 = "akat";
        String s2 = "atak";
        int[][] a = new int[s1.length()+1][s2.length()+1];
        for (int i = 0; i< a.length; i++){
            for (int j = 0; j<a[0].length; j++){
                a[i][j] = -1;
            }
        }
        System.out.println(LongestCommon(s1,s2,0,0,a));
    }
    public static int LongestCommon(String s1, String s2, int index1, int index2 , int[][] a){
        if (index1 == s1.length() || index2 == s2.length()){
            a[index1][index2] = 0;
            return 0;
        }
        int c = 0;
        if (a[index1][index2] != -1){
            return a[index1][index2];
        }
        if (s1.charAt(index1) == s2.charAt(index2)) {
            c =  1 + LongestCommon(s1, s2, index1+1, index2+1 , a);
        }
        int p1 = LongestCommon(s1, s2, index1+1, index2, a);
        int p2 = LongestCommon(s1, s2, index1, index2+1, a);
        a[index1][index2] = Math.max(c,Math.max(p1,p2));
        return a[index1][index2];
    }
}
